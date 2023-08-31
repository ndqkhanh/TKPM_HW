import express from "express";
import bodyParser from "body-parser";
import {
  addProduct,
  deleteProduct,
  getListProducts,
  getProductById,
  updateProduct,
} from "./ProductDAO";
import Product from "./Product";
require("dotenv").config();

const app = express();

app.use(bodyParser.json());

app.get("/product/:id", (req, res) => {
  const { id } = req.params;
  const product = getProductById(id);
  res.send(product);
});

app.get("/product-list", async (req, res) => {
  const products = await getListProducts();
  res.send(products);
});

app.post("/add-product", async (req, res) => {
  const { thumbnail, name, description, price } = req.body;
  const product: Product = {
    id: "0",
    thumbnail,
    name,
    description,
    price,
  };
  const result = await addProduct(product);
  res.send(result);
});

app.post("/update-product/:id", async (req, res) => {
  const { id } = req.params;
  const { thumbnail, name, description, price } = req.body;
  const product: Product = {
    id: id,
    thumbnail,
    name,
    description,
    price,
  };
  const result = await updateProduct(id, product);
  res.send(result);
});

app.post("/delete-product/:id", async (req, res) => {
  const { id } = req.params;
  const result = await deleteProduct(id);
  res.send(result);
});

const PORT = process.env.PORT;

app.listen({ port: PORT }, () =>
  console.log(`Server DAO running on port ${PORT}`)
);
