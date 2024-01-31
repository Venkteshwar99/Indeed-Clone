import { Select, MenuItem, FormControl, InputLabel } from "@mui/material";

const DropDown = ({
  id,
  value,
  handleChange,
  name,
  label,
  options,
  ...props
}) => {
  return (
    <FormControl>
      <InputLabel id={id}>{label}</InputLabel>
      <Select
        value={value}
        onChange={handleChange}
        name={name}
        labelId={id}
        id={id}
        {...props}
      >
        {options.map((option) => (
          <MenuItem value={option}>{option}</MenuItem>
        ))}
      </Select>
    </FormControl>
  );
};

export default DropDown;
