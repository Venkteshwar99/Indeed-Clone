import Header from "../Components/Header";
import { useEffect, useState } from "react";
import { getAllPosts } from "../Services/Api";
import { InputBase, Box, Card, CardContent, Typography } from "@mui/material";
import styled from "@emotion/styled";

const SearchWrapper = styled(Box)({
  marginTop: 84,
  display: "flex",
  justifyContent: "center",
  "& > div": {
   width:'100%',
    maxWidth: 500,
    height: 45,
    border: "1px solid #767676",
    borderRadius: 10,
    display: "flex",
    alignItems: "center",
    marginRight: 20,
    paddingLeft: 10,
  },
});

const PostWrapper = styled(Box)({
  display: "flex",
  justifyContent: "center",
  marginTop: 50,
  flexWrap: "wrap",
  gap:20,
  "& > div": {
    border: "1px solid #442d0",
    borderRadius: 10,
    margin: 10,
    width:'100%',
    maxWidth: "30%",
    height: 290,
    minWidth:250
  },
});

const AllPosts = () => {
  const [posts, setPosts] = useState([]);
  const [text, setText] = useState("");
  const [error, setError] = useState(null);

  useEffect(() => {
    const getData = async () => {
     try{
      const response = await getAllPosts();
      setPosts(response.data);}
      catch(error){
       setError("API is not active or an error occurred.");  
      }
    };
    getData();
  }, []);
 
 if(error){
   return (
<><Header/>
   <div style={{color:'red',fontSize:'18px',textAlign:'center',marginTop:'200px',fontWeight:'bold'}}>{error}</div>
   </>
)}

  return (
    <>
      <Header />
      <SearchWrapper>
        <InputBase
          placeholder="Search by Job Title"
          onChange={(e) => setText(e.target.value)}
        />
      </SearchWrapper>

      <PostWrapper>
        {posts
          .filter((post) =>
            post.profile.toLowerCase().includes(text.toLowerCase())
          )
          .map((post) => (
            <Card>
              <CardContent>
                <Typography variant="h6">{post.profile}</Typography>
                <Typography>
                  {post.type === "Offline" ? "Remote" : "Office"}
                </Typography>
                <Typography>Salary: {post.salary}</Typography>
                <Typography
                  style={{
                    color: "#6f6f6f",
                    margin: "10px 0",
                  }}
                >
                  Description:{" "}
                  {post.description.length > 150
                    ? post.description.substring(0, 150) + "..."
                    : post.description}
                </Typography>
                <Typography>
                  <b>Experience</b>: {post.experience}
                </Typography>
                <Typography>
                  <b>Technology</b>:{" "}
                  {post.technology.map((item) => (
                    <span>{item + " "}</span>
                  ))}
                </Typography>
                <Typography
                  style={{
                    color: "#6f6f6f",
                    margin: "auto",
                  }}
                >
                  Posted on: {new Date(post.createdAt).toLocaleDateString()}
                </Typography>
              </CardContent>
            </Card>
          ))}
      </PostWrapper>
    </>
  );
};

export default AllPosts;
