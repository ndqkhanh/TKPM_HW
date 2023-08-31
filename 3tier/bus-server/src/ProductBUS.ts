import Product from "./Product";
import fetch from "cross-fetch";
require("dotenv").config();

const getProductByIdFromDAO = async (id: string) => {
  // Fetch product from DAO_SERVER_URL
  console.log(`GET /product/${id}`);
  const url = `${process.env.DAO_SERVER_URL}/product/${id}`;
  const response = await fetch(url);
  const product = await response.json();
  return product;
};

const getListProductsFromDAO = async () => {
  // Fetch product from DAO_SERVER_URL
  console.log("GET /product-list");
  const url = `${process.env.DAO_SERVER_URL}/product-list`;
  const response = await fetch(url);
  const products = await response.json();
  return products;
};

const addProductFromDAO = async (product: Product) => {
  console.log("POST /add-product");
  // Fetch product from DAO_SERVER_URL
  const url = `${process.env.DAO_SERVER_URL}/add-product`;
  const response = await fetch(url, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(product),
  });
  const newProduct = await response.json();
  return newProduct;
};

const updateProductFromDAO = async (id: string, product: Product) => {
  console.log(`POST /update-product/${id}`);
  //Check if product exists
  const productExists = await getProductByIdFromDAO(id);
  if (!productExists) {
    throw new Error("Product not found");
  }

  // Fetch product from DAO_SERVER_URL
  const url = `${process.env.DAO_SERVER_URL}/update-product/${id}`;
  const response = await fetch(url, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(product),
  });
  const updatedProduct = await response.json();
  return updatedProduct;
};

const deleteProductFromDAO = async (id: string) => {
  console.log(`POST /delete-product/${id}`);
  //Check if product exists
  const productExists = await getProductByIdFromDAO(id);
  if (!productExists) {
    throw new Error("Product not found");
  }

  // Fetch product from DAO_SERVER_URL
  const url = `${process.env.DAO_SERVER_URL}/delete-product/${id}`;
  const response = await fetch(url, {
    method: "POST",
  });
  const deletedProduct = await response.json();
  return deletedProduct;
};

export {
  getProductByIdFromDAO,
  getListProductsFromDAO,
  addProductFromDAO,
  updateProductFromDAO,
  deleteProductFromDAO,
};
