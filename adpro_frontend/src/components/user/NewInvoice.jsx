import React from 'react'

function NewInvoice() {
    return (
        <>
            <main id="main" className="main">
                <div className="container mt-5">
                    <div className="card shadow">
                        <div className="card-header bg-primary text-white text-center">
                            <h5>Invoice Information</h5>
                        </div>
                        <div className="card-body">
                            <form>
                                {/* First Row */}
                                <div className="row mb-3">
                                    <div className="col-md-3">
                                        <label className="form-label fw-bold"> Amount <span className="text-danger">*</span></label>
                                        <input type="number" className="form-control" name="amount" />
                                    </div>
                                    <div className="col-md-3">
                                        <label className="form-label fw-bold"> Discount Amount <span className="text-danger">*</span></label>
                                        <input type="number" className="form-control" name="discountAmount" required />
                                    </div>
                                    <div className="col-md-3">
                                        <label className="form-label fw-bold">Taxable Amount <span className="text-danger">*</span></label>
                                        <input type="number" className="form-control" name="taxableAmount" required />
                                    </div>

                                    <div className="col-md-3">
                                        <label className="form-label fw-bold">GST Tax Type <span className="text-danger">*</span></label>
                                        <select className="form-select" name="gstTaxType" required >
                                            <option value="">Select</option>
                                            <option value="CGST_SGST">CGST + SGST</option>
                                            <option value="IGST">IGST</option>
                                        </select>
                                    </div>
                                </div>

                                {/* Second Row */}
                                <div className="row mb-3">

                                    <div className="col-md-2">
                                        <label className="form-label fw-bold">CGST %</label>
                                        <input type="number" className="form-control" name="cgstPercent" />
                                    </div>
                                    <div className="col-md-2">
                                        <label className="form-label fw-bold">CGST Amount</label>
                                        <input type="number" className="form-control" name="cgstAmount" />
                                    </div>
                                    <div className="col-md-2">
                                        <label className="form-label fw-bold">SGST %</label>
                                        <input type="number" className="form-control" name="sgstPercent" />
                                    </div>
                                    <div className="col-md-2">
                                        <label className="form-label fw-bold">SGST Amount</label>
                                        <input type="number" className="form-control" name="sgstAmount" />
                                    </div>
                                    <div className="col-md-2">
                                        <label className="form-label fw-bold">IGST %</label>
                                        <input type="number" className="form-control" name="igstPercent" />
                                    </div>
                                    <div className="col-md-2">
                                        <label className="form-label fw-bold">IGST Amount</label>
                                        <input type="number" className="form-control" name="igstAmount" />
                                    </div>
                                </div>

                                {/* Third Row */}
                                <div className="row mb-3">
                                    <div className="col-md-6">
                                        <label className="form-label fw-bold">Bill Amount</label>
                                        <input type="number" className="form-control" name="billAmount" />
                                    </div>
                                    <div className="col-md-6">
                                        <label className="form-label fw-bold">Advance</label>
                                        <input type="number" className="form-control" name="advance" />
                                    </div>
                                </div>

                                {/* Buttons */}
                                <div className="d-flex justify-content-center">
                                    <button type="submit" className="btn btn-success me-2">Save</button>
                                    <button type="reset" className="btn btn-danger me-2">Cancel</button>
                                    <button className="btn btn-primary">Print Invoice</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </main>
        </>
    )
}

export default NewInvoice