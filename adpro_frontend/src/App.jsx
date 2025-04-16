
import { BrowserRouter, Routes, Route } from "react-router-dom"

import ForgotPassword from "./components/ForgotPassword"
import Login from "./components/Login"
import Register from "./components/Register"
import Dashboard from "./components/user/Dashboard"
import Landing from "./components/user/Landing"
import Clients from "./components/user/masters/Clients"
import Employees from "./components/user/masters/Employees"
import PMedia from "./components/user/masters/PMedia"
import EMedia from "./components/user/masters/EMedia"
import Holidays from "./components/user/masters/Holidays"
import GstTaxPlanning from "./components/user/masters/GstTaxPlanning"
import ClientList from "./components/user/general reports/ClientList"
import HolidaysList from "./components/user/general reports/HolidaysList"
import DesignPrintInvoices from "./components/user/DesignPrintInvoices"
import EmployeeWork from "./components/user/general reports/EmployeeWork"
import ClientAds from "./components/user/general reports/ClientAds"
import NewInvoice from "./components/user/NewInvoice"
import EMediaRoList from "./components/user/financial report/EMediaRoList"
import DesignPrintReport from "./components/user/financial report/DesignPrintReport"
import PMediaRoList from "./components/user/financial report/PMediaRoList"





function App() {

  return (
    <>

      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/signup" element={<Register />} />
          <Route path="/forgot-password" element={<ForgotPassword />} />


          <Route path="dashboard" element={<Landing />}>
            <Route index element={<Dashboard />} />
          </Route>

          <Route path="masters" element={<Landing />}>
            <Route path="clients" element={<Clients />} />
            <Route path="employees" element={<Employees />} />
            <Route path="pmedia" element={<PMedia />} />
            <Route path="emedia" element={<EMedia />} />
            <Route path="holidays" element={<Holidays />} />
            <Route path="gst-tax-planning" element={<GstTaxPlanning />} />
          </Route>

          <Route path="design-print-invoices" element={<Landing />}>
            <Route index element={<DesignPrintInvoices />} />
          </Route>
          <Route path="design-print-invoices/new-invoice" element={<Landing />}>
            <Route index element={<NewInvoice />} />
          </Route>

          <Route path="financial-reports" element={<Landing />}>
          <Route path="e-media-ro-list" element={<EMediaRoList />} />
            <Route path="p-media-ro-list" element={<PMediaRoList />} />
            <Route path="design-print-report"  element={<DesignPrintReport/>}/>
          </Route>

          <Route path="general-reports" element={<Landing />}>
          <Route path="employee-work" element={<EmployeeWork />} />
            <Route path="client-list" element={<ClientList />} />
            <Route path="client-ads"  element={<ClientAds/>}/>
            <Route path="holidays-list" element={<HolidaysList />} />
          </Route>

        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
