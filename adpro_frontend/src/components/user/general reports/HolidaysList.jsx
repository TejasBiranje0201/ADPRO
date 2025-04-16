import axios from 'axios';
import React, { useEffect, useState } from 'react'
import * as XLSX from "xlsx"; // Import the xlsx library

function HolidaysList() {

    //to print the holidays list
    const handlePrint = () => {
        const printContent = document.getElementById("printableTable").innerHTML;
        const originalContent = document.body.innerHTML;

        document.body.innerHTML = printContent;
        window.print();
        document.body.innerHTML = originalContent;
        window.location.reload(); // Refresh the page to restore the UI
    };

    //to export the Holidays list to excel
    const exportToExcel = () => {
        const worksheet = XLSX.utils.json_to_sheet(holidays);
        const workbook = XLSX.utils.book_new();
        XLSX.utils.book_append_sheet(workbook, worksheet, "Holidays");
        XLSX.writeFile(workbook, "Holidays.xlsx");
    };
    return (
        <>
            <main id="main" className="main">
                <div className="pagetitle">
                    <h1>General Reports</h1>
                    <nav>
                        <ol className="breadcrumb">
                            <li className="breadcrumb-item"><a>Home</a></li>
                            <li className="breadcrumb-item"><a>General Reports</a></li>
                            <li className="breadcrumb-item active">Holidays List</li>
                        </ol>
                    </nav>
                </div>

                {/* Buttons */}
                <div className="d-flex flex-wrap gap-2 mb-3">
                    <button className="btn btn-primary" onClick={handlePrint}>
                        Print Holidays List
                    </button>
                    <button className="btn btn-success ms-2" onClick={exportToExcel}>
                        Export to Excel
                    </button>
                </div>

                <div className='text-end me-5'>
                    <span className=" text-danger fw-bold h6">Total Records : 1</span>
                </div>

                {/* Holidays Table */}
                <div className="container mt-4" id="printableTable">
                    <div className="card shadow-lg card-responsive ">
                        <div className="card-header bg-white text-dark text-center my-3">
                            <h5 className="fw-bold">Holidays List</h5>
                        </div>
                        <div className="card-body px-3">
                            <div className="table-responsive">
                                <table className="table table-hover table-bordered text-center">
                                    <thead className="table-secondary">
                                        <tr>
                                            <th>No</th>
                                            <th>Date</th>
                                            <th>Reason</th>
                                            <th>Every Year</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>26/01/2025</td>
                                            <td>Republic Day</td>
                                            <td>Yes</td>
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

export default HolidaysList