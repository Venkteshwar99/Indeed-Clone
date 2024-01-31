import axios from "axios";
const API_URL = "http://localhost:8081/indeed";

export const savePost = async (payload) => {
  try {
    return await axios.post(`${API_URL+"/post"}`, payload);
  } catch (error) {
    console.log("Error", error.message);
  }
};
