import axios from 'axios';
import React, { useEffect, useState } from 'react';
import Swal from 'sweetalert2';

function Clients() {
    const [id, setId] = useState(null); // State to store the ID of the client being updated

    //to get client data
    const [clientData, setClientData] = useState([]);

    function loadData() {
        //console.log(import.meta.env.VITE_BASEURL + "/clients");
        axios.get(import.meta.env.VITE_BASEURL + "/clients")
            .then((res) => {
                console.log(res.data);
                setClientData(res.data);
            })
            .catch((error) => console.error("Error fetching client:", error));
    };

    useEffect(() => {
        loadData()
    }, [])

    // to get state data
    const [state, setState] = useState([]);
    useEffect(() => {
        axios.get(import.meta.env.VITE_BASEURL + "/states")
            .then((res) => {
                // console.log(res.data);
                setState(res.data);
            })
    }, [])

    // to get agency data
    // const [agency, setAgency] = useState([]);
    // useEffect(() => {
    //     axios.get(import.meta.env.VITE_BASEURL + "/agencies")
    //         .then((res) => {
    //             // console.log(res.data);
    //             setAgency(res.data);
    //         })
    // }, [])

    //to post data
    const [client, setClient] = useState({
        name: "",
        contact: "",
        address: "",
        stateId: "",
        gstNo: "",
        // agencyId: ""
    });

    // Handle Input Change
    const handleChangeClientData = (e) => {
        //console.log(e.target.value)
        setClient({ ...client, [e.target.name]: e.target.value });
    };


    // Handle Form Submission (Save Or Update)
    const handleSubmitClientData = async (e) => {
        e.preventDefault();

        if (!id) {
            try {
                const response = await axios.post(`${import.meta.env.VITE_BASEURL}/clients`, client);
                alert("Client added successfully!");
                console.log(response.data);
                setClient({ name: "", contact: "", address: "", stateId: "", gstNo: "" }); // Clear form
            } catch (error) {
                console.error("Error adding Client:", error);
            }
        } else {
            try {
                const response = await axios.post(`${import.meta.env.VITE_BASEURL}/clients`, { ...client, id }); // Include ID for update
                alert("Client updated successfully!");
                console.log(response.data);
                setId(null); // Reset ID after updating
                setClient({ name: "", contact: "", address: "", stateId: "", gstNo: "" }); // Clear form
            } catch (error) {
                console.error("Error updating Client:", error);
            }
        }

        loadData(); // Refresh client list after operation
    };

    //To delete data
    function handleDelete(id) {
        Swal.fire({
            title: "Are you sure?",
            text: "You won't be able to revert this!",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#d33",
            cancelButtonColor: "#3085d6",
            confirmButtonText: "Yes, delete it!"
        }).then((result) => {
            if (result.isConfirmed) {
                axios.delete(import.meta.env.VITE_BASEURL + "/clients/" + id)
                    .then((res) => {
                        console.log(res.data);
                        loadData(); // Refresh the data after deletion
                        Swal.fire({
                            title: "Deleted!",
                            text: "Your item has been deleted.",
                            icon: "success"
                        });
                    })
                    .catch((error) => {
                        console.error("Error deleting item:", error);
                        Swal.fire({
                            title: "Error!",
                            text: "Something went wrong. Please try again later.",
                            icon: "error"
                        });
                    });
            }
        });
    }

    //To get data in form for update
    function handleUpdate(id) {
        axios.get(import.meta.env.VITE_BASEURL + "/clients/" + id)
            .then((res) => {
                //console.log(res.data.data);

                // Populate the form fields with fetched client data
                setClient({
                    name: res.data.name,
                    contact: res.data.contact,
                    address: res.data.address,
                    stateId: res.data.stateId,
                    gstNo: res.data.gstNo,
                    agencyId: res.data.agencyId
                });

                setId(id); // Store the ID to switch to "update mode"
            })
            .catch((err) => {
                console.error("Error fetching client data:", err);
            });

    };

    return (
        <>
            <main id="main" className="main">
                <div class="pagetitle">
                    <h1>Clients</h1>
                    <nav>
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a>Home</a></li>
                            <li class="breadcrumb-item"><a>Masters</a></li>
                            <li class="breadcrumb-item active">Clients</li>
                        </ol>
                    </nav>
                </div>

                {/* Client Form */}
                <div class="container">
                    <div class="card shadow">
                        <div class="card-header bg-primary text-white text-center">
                            <h5>Client Information</h5>
                        </div>
                        <div class="card-body">
                            <form onSubmit={handleSubmitClientData}>
                                {/* <!-- First Row: Client Name & Contact --> */}
                                <div class="row mb-3">
                                    <div class="col-md-6 col-sm-6">
                                        <label for="clientName" class="form-label fw-bold">Client Name <span class="text-danger">*</span></label>
                                        <input onChange={handleChangeClientData} value={client.name} name="name" type="text" class="form-control" placeholder="Enter client name" required />
                                    </div>
                                    <div class="col-md-6 col-sm-6">
                                        <label for="contact" class="form-label fw-bold">Contact <span class="text-danger">*</span></label>
                                        <input onChange={handleChangeClientData} value={client.contact} name="contact" type="tel" class="form-control" placeholder="Enter contact number" required />
                                    </div>
                                </div>

                                {/* <!-- Second Row: Address--> */}
                                <div class="row mb-3">
                                    <div class="col-md-12">
                                        <label for="address" class="form-label fw-bold">Address <span class="text-danger">*</span></label>
                                        <textarea onChange={handleChangeClientData} value={client.address} name="address" class="form-control" rows="2" placeholder="Enter address" required></textarea>
                                    </div>
                                </div>

                                {/* <!-- Third Row: State  &  GST Number--> */}
                                <div class="row mb-3">
                                    <div class="col-md-6 col-sm-6">
                                        <label for="state" class="form-label fw-bold">State <span class="text-danger">*</span></label>
                                        <select value={client.stateId} onChange={handleChangeClientData} class="form-select" name="stateId" required>
                                            <option value={""} selected disabled>Select State</option>
                                            {
                                                state.map((state) => {
                                                    //console.log(roleData);
                                                    return (
                                                        <option key={state.id} value={state.id}> {state.name} </option>
                                                    )
                                                })
                                            }
                                        </select>
                                    </div>
                                    <div className="col-md-6 col-sm-6">
                                        <label for="gst" class="form-label fw-bold">GST Number <span class="text-danger">*</span></label>
                                        <input onChange={handleChangeClientData} value={client.gstNo} name="gstNo" type="text" class="form-control" id="gstNo" placeholder="Enter GST number" required />
                                    </div>

                                </div>

                                {/* <!-- Fourth Row: Agency --> */}
                                {/* <div className="row mb-3">
                               <div class="col-md-6">
                                    <label for="Agency" class="form-label fw-bold">Agency <span class="text-danger">*</span></label>
                                    <select value={client.agencyId} onChange={handleChangeClientData} class="form-select" name="agencyId">
                                        <option value={""} selected disabled>Select Agency</option>
                                        {
                                            agency.map((agency) => {
                                                //console.log(roleData);
                                                return (
                                                    <option key={agency.id} value={agency.id}> {agency.name} </option>
                                                )
                                            })
                                        }
                                    </select>
                                </div>
                               </div> */}

                                {/* <!-- Buttons --> */}
                                <div class="d-flex justify-content-end">
                                    <button type="submit" class="btn btn-success me-2">Save</button>
                                    <button type="reset" class="btn btn-danger">Cancel</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                {/* Client Table */}
                <div class="container mt-5">
                    <div class="card shadow-lg">
                        <div class="card-header bg-white text-dark text-center my-3">
                            <h5 class="fw-bold">Client List</h5>
                        </div>
                        <div class="card-body">
                           <div className="table-responsive">
                           <table class="table table-hover table-bordered text-center">
                                <thead class="table-secondary">
                                    <tr>
                                        <th>ID</th>
                                        <th>Client Name</th>
                                        <th>Contact</th>
                                        <th>Address</th>
                                        <th>State</th>
                                        <th>GST No.</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {
                                        clientData.map((eachData, index) => {
                                            return (
                                                <tr>
                                                    <td>{index + 1}</td>
                                                    <td>{eachData.name}</td>
                                                    <td>{eachData.contact}</td>
                                                    <td>{eachData.address}</td>
                                                    <td>{eachData.statename}</td>
                                                    <td>{eachData.gstNo}</td>
                                                    <td>
                                                    <div className="d-flex justify-content-center flex-wrap gap-1">
                                                                <button className="btn btn-primary btn-sm" onClick={() => handleUpdate(eachData.id)}>
                                                                    <i className="bi bi-pencil-square"></i>
                                                                </button>
                                                                <button className="btn btn-danger btn-sm" onClick={() => handleDelete(eachData.id)} >
                                                                    <i className="bi bi-trash"></i>
                                                                </button>
                                                            </div>
                                                    </td>

                                                </tr>
                                            )
                                        })
                                    }
                                </tbody>
                            </table>
                           </div>
                        </div>
                    </div>
                </div>

            </main>
        </>
    )
}

export default Clients