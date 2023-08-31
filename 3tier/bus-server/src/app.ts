import express from "express";
import bodyParser from "body-parser";
import {
  addProductFromDAO,
  deleteProductFromDAO,
  getListProductsFromDAO,
  updateProductFromDAO,
} from "./ProductBUS";
import Product from "./Product";
require("dotenv").config();

const app = express();

app.use(bodyParser.json());

app.get("/product-list", async (req, res) => {
  const products = await getListProductsFromDAO();
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
  const result = await addProductFromDAO(product);
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
  const result = await updateProductFromDAO(id, product);
  res.send(result);
});

app.post("/delete-product/:id", async (req, res) => {
  const { id } = req.params;
  const result = await deleteProductFromDAO(id);
  res.send(result);
});

const PORT = process.env.PORT;

app.listen({ port: PORT }, () =>
  console.log(`Server BUS running on port ${PORT}`)
);
