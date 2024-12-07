document.getElementById("client-form").addEventListener("submit", handleSubmit);

async function handleSubmit(event) {
  event.preventDefault();
  const outputDiv = document.getElementById("output");
  const form = event.target;
  const formData = new FormData(form);

  const data = {};
  formData.forEach((value, key) => {
    data[key] = value;
  });

  console.log(data);

  const response = await Promise.all([
    fetch("http://localhost:3000/exchange", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    }),
    fetch("http://localhost:3000/order", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    }),
    fetch("http://localhost:3000/enough-tickets", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    }),
  ]);

  if (response.some((res) => !res.ok)) {
    outputDiv.innerHTML = "<p>Cliente nao encontrado</p>";
    return;
  }

  const jsonData = await Promise.all(response.map((res) => res.json()));

  outputDiv.innerHTML = `
    <p><strong>Quantidade de Trocas:</strong> ${jsonData.shift()}</p>
    <p><strong>Quantidade de Pedidos:</strong> ${jsonData.shift()}</p>
    <p><strong>Pode realizar troca:</strong> ${
      jsonData.shift() ? "Sim" : "Nao"
    }</p>
  `;
}
