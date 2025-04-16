import React from 'react'
import { Link } from 'react-router'

function DesignPrintInvoices() {
  return (
    <>
      <main id="main" className="main">
        <div class="pagetitle">
          <h1>Designing & Printing Invoices</h1>
          <nav>
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a>Home</a></li>
              <li class="breadcrumb-item active">Designing & Printing Invoices</li>
            </ol>
          </nav>
        </div>

        <div class="container mt-4">
          <div class="row g-3 align-items-end">
            <div class="col-md-3 col-sm-6">
              <label for="client" class="form-label fw-bold">CLIENT</label>
              <select class="form-select shadow" id="client">
                <option selected>Select Client</option>
                <option value="1">Client 1</option>
                <option value="2">Client 2</option>
                <option value="3">Client 3</option>
              </select>
            </div>
            <div class="col-md-3 col-sm-6">
              <label for="fromDate" class="form-label fw-bold">FROM DATE</label>
              <input type="date" class="form-control shadow" id="fromDate" />
            </div>
            <div class="col-md-3 col-sm-6">
              <label for="toDate" class="form-label fw-bold">TO DATE</label>
              <input type="date" class="form-control shadow" id="toDate" />
            </div>
            <div class="col-md-3 col-sm-6">
              <label for="search" class="form-label fw-bold">SEARCH</label>
              <input type="text" class="form-control shadow" id="search" placeholder="Search..." />
            </div>
          </div>
          <div class="row mt-4">
            <div class="col-12 text-center">
              <button class="btn btn-primary me-2">Show</button>
              <button class="btn btn-danger me-2">Reset</button>
              <Link to="/design-print-invoices/new-invoice" className="btn btn-success">Add New Invoice</Link>
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
              <h5 className="fw-bold">Invoice List</h5>
            </div>
            <div className="card-body px-3">
              <div className="table-responsive">
                <table className="table table-hover table-bordered text-center align-middle">
                  <thead className="table-secondary">
                    <tr>
                      <th>Invoice No</th>
                      <th>Invoice Date</th>
                      <th>Client</th>
                      <th>Amount</th>
                      <th>Discount</th>
                      <th>Taxable Amount</th>
                      <th>CGST %</th>
                      <th>CGST Amount</th>
                      <th>SGST %</th>
                      <th>SGST Amount</th>
                      <th>IGST %</th>
                      <th>IGST Amount</th>
                      <th>Invoice Amount</th>
                      <th>Paid</th>
                      <th>Remaining</th>
                      <th>Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>..</td>
                      <td>..</td>
                      <td>..</td>
                      <td>..</td>
                      <td>..</td>
                      <td>..</td>
                      <td>..</td>
                      <td>..</td>
                      <td>..</td>
                      <td>..</td>
                      <td>..</td>
                      <td>..</td>
                      <td>..</td>
                      <td>..</td>
                      <td>..</td>
                      <td>
                        {/* First row of buttons */}
                        <div className="d-flex justify-content-center">
                          <button className="btn btn-sm btn-primary me-2" style={{ height: "30px", width: "30px" }}><i className="fas fa-edit"></i></button>
                          <button className="btn btn-sm btn-danger" style={{ height: "30px", width: "30px" }}><i className="fas fa-trash-alt"></i></button>
                        </div>
                        {/* Second row of buttons */}
                        <div className="d-flex justify-content-center mt-1">
                          <button className="btn btn-sm btn-success me-2" style={{ height: "30px", width: "30px" }}><i class="fa-solid fa-indian-rupee-sign"></i></button>
                          <button className="btn btn-sm btn-dark" style={{ height: "30px", width: "30px" }}><i className="fas fa-print"></i></button>
                        </div>
                      </td>
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

export default DesignPrintInvoices