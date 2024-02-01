import axios from "axios";
const API_URL = "http://localhost:8081/indeed";

export const savePost = async (payload) => {
  try {
    return await axios.post(`${API_URL + "/post"}`, payload);
  } catch (error) {
    console.log("Error", error.message);
  }
};

export const getAllPosts = async () => {
  try {
    return await axios.get(`${API_URL + "/findAll"}`);
  } catch (error) {
    console.log("Error", error.message);
  }
};
