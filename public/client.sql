CREATE TABLE clients (
    id SERIAL PRIMARY KEY,        -- Unique identifier for each client
    name VARCHAR(255) NOT NULL,   -- Name of the client
    num_exchanges INT DEFAULT 0,  -- Number of exchanges, default to 0
    num_tickets INT DEFAULT 0,    -- Number of tickets, default to 0
    num_orders INT DEFAULT 0      -- Number of orders, default to 0
);
