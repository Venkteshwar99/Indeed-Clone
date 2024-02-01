import "./App.css";
import Home from "./Pages/Home";
import CreatePost from "./Pages/CreatePost";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { routePath } from "./Routes/Route";
import AllPosts from "./Pages/AllPosts";

function App() {
  return (
    <Router>
      <Routes>
        <Route path={routePath.Home} element={<Home />} />;
        <Route path={routePath.Create} element={<CreatePost />} />
        <Route path={routePath.Posts} element={<AllPosts />} />
      </Routes>
    </Router>
  );
}

export default App;
