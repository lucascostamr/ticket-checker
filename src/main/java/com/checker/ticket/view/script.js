document
  .getElementById("client-form")
  .addEventListener("submit", function (event) {
    event.preventDefault();
    const form = event.target;
    const formData = new FormData(form);

    const data = {};
    formData.forEach((value, key) => {
      data[key] = value;
    });

    console.log(data);
  });
