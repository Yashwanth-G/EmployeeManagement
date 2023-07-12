import React, { useEffect, useState } from "react";
import { listEmployees, removeEmployee } from "../services/EmployeeService";
import { useNavigate } from "react-router-dom";

const ListEmployeeComponent = () => {
  // Populating real employees data
  // In order to hold the response of the RESTAPI we have to use the state variable
  // In functional components inorder to define state variables we have to use useState hook

  const [employees, setEmployees] = useState([]);

  const naviagtor = useNavigate();
  // In order to make RESTAPI call or AJAX call in react functional component
  // we have to use useEffect hook

  useEffect(() => {
    getAllEmployees();
  }, []);

  function getAllEmployees() {
    listEmployees()
      .then((response) => {
        setEmployees(response.data);
      })
      .catch((err) => console.log(err));
  }

  const addNewEmployee = () => {
    // In order to navigate from one page to another page we have to use
    // useNavigate hook
    naviagtor("/add-employee");
  };

  function udpateEmployee(id) {
    naviagtor(`/edit-employee/${id}`);
  }

  function deleteEmployee(id) {
    console.log(id);
    removeEmployee(id)
      .then((res) => {
        getAllEmployees();
      })
      .catch((err) => console.log(err));
  }

  return (
    <div className="container">
      <h2 className="text-center">List of Employees</h2>
      <button className="btn btn-primary" onClick={addNewEmployee}>
        Add Employee
      </button>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Employee Id</th>
            <th>Employee First Name</th>
            <th>Employee Last Name</th>
            <th>Employee Email Id</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {employees.map((employee) => (
            <tr key={employee.id}>
              <td>{employee.id}</td>
              <td>{employee.firstName}</td>
              <td>{employee.lastName}</td>
              <td>{employee.email}</td>
              <td>
                <button
                  className="btn btn-info"
                  onClick={() => udpateEmployee(employee.id)}
                >
                  Update
                </button>
                <button
                  className="btn btn-danger"
                  onClick={() => deleteEmployee(employee.id)}
                  style={{ marginLeft: "10px" }}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListEmployeeComponent;
