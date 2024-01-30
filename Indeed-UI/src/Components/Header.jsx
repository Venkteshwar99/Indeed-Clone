import { AppBar, Toolbar, styled } from "@mui/material";

const StyledAppBar = styled(AppBar)({
  background: "#2d2d2d",
  height: 64,
});
const Header = () => {
  const logo =
    "https://get-staffed.com/wp-content/uploads/2020/07/indeed-logo.png";
  return (
    <StyledAppBar>
      <Toolbar>
        <img src={logo} alt="logo" style={{ width: 95, marginBottom: 6 }} />
        Post a Job Find Jobs
      </Toolbar>
    </StyledAppBar>
  );
};

export default Header;
