import React from 'react'

function ClientAds() {
    return (
        <>
            <main id="main" className="main">
                <div className="pagetitle">
                    <h1>General Reports</h1>
                    <nav>
                        <ol className="breadcrumb">
                            <li className="breadcrumb-item"><a>Home</a></li>
                            <li className="breadcrumb-item"><a>General Reports</a></li>
                            <li className="breadcrumb-item active">Employee Work</li>
                        </ol>
                    </nav>
                </div>

                <div class="container mt-4">
                    <div class="row g-3 align-items-end">
                        <div class="col-md-4 col-sm-6">
                            <label for="client" class="form-label fw-bold">CLIENT</label>
                            <select class="form-select shadow" id="client">
                                <option selected>Select Client</option>
                                <option value="1">Client 1</option>
                                <option value="2">Client 2</option>
                                <option value="3">Client 3</option>
                            </select>
                        </div>

                        <div class="col-md-4 col-sm-6">
                            <label for="fromDate" class="form-label fw-bold">FROM DATE</label>
                            <input type="date" class="form-control shadow" id="fromDate" />
                        </div>
                        <div class="col-md-4 col-sm-6">
                            <label for="toDate" class="form-label fw-bold">TO DATE</label>
                            <input type="date" class="form-control shadow" id="toDate" />
                        </div>
                    </div>
                    <div class="row mt-4">
                        <div class="col-12 text-center">
                            <button class="btn btn-info me-2 text-white">Show</button>
                            <button class="btn btn-danger me-2">Reset</button>
                            <button class="btn btn-primary me-2">Print</button>
                            <button class="btn btn-success me-2">Export</button>
                        </div>
                    </div>
                </div>
                <hr />


                <div className='text-end me-5'>
                    <span className=" text-danger fw-bold h6">Total Records : 1</span>
                </div>

                {/* Table */}
                <div className="container mt-4">
                    <div className="card shadow-lg card-responsive ">
                        <div className="card-header bg-white text-dark text-center my-3">
                            <h5 className="fw-bold">Client Ads Report</h5>
                        </div>
                        <div className="card-body px-3">
                            <div className="table-responsive">
                                <table className="table table-hover table-bordered text-center align-middle">
                                    <thead className="table-secondary">
                                        <tr>
                                            <th>No</th>
                                            <th>Client Name</th>
                                            <th>Date</th>
                                            <th>Description</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>GreenTech Solutions</td>
                                            <td>12/02/2024</td>
                                            <td>Event Ad</td>
                                        </tr>
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

export default ClientAds