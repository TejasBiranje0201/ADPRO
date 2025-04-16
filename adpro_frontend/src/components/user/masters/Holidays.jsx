import React, { useState, useEffect } from "react";

function Holidays() {
    const [month, setMonth] = useState(2); // Default to March
    const [year, setYear] = useState(2025);
    const [days, setDays] = useState([]);

    useEffect(() => {
        generateCalendar(month, year);
    }, [month, year]);

    function generateCalendar(selectedMonth, selectedYear) {
        const firstDay = new Date(selectedYear, selectedMonth, 1).getDay();
        const daysInMonth = new Date(selectedYear, selectedMonth + 1, 0).getDate();
        let date = 1;
        let calendarDays = [];

        for (let i = 0; i < 6; i++) {
            let row = [];
            for (let j = 0; j < 7; j++) {
                if (i === 0 && j < firstDay) {
                    row.push(null);
                } else if (date > daysInMonth) {
                    row.push(null);
                } else {
                    row.push({
                        date,
                        isSunday: j === 0 // Check if the day is Sunday
                    });
                    date++;
                }
            }
            calendarDays.push(row);
        }

        setDays(calendarDays);
    }

    return (
        <main id="main" className="main">
            <div className="container mt-4">
                <h3 className="text-primary text-center">HOLIDAYS PLANNER</h3>
                <div className="d-flex justify-content-center my-3">
                    <select
                        className="form-select w-auto me-2 shadow"
                        value={month}
                        onChange={(e) => setMonth(parseInt(e.target.value))}
                    >
                        {[
                            "January", "February", "March", "April", "May", "June",
                            "July", "August", "September", "October", "November", "December"
                        ].map((m, index) => (
                            <option key={index} value={index}>{m}</option>
                        ))}
                    </select>
                    <select
                        className="form-select w-auto shadow"
                        value={year}
                        onChange={(e) => setYear(parseInt(e.target.value))}
                    >
                        <option value="2024">2024</option>
                        <option value="2025">2025</option>
                        <option value="2026">2026</option>
                    </select>
                </div>

                <div className="card shadow p-3 px-4">
                    <div className="text-center fw-bold text-primary fs-5 pb-3">
                        {`${new Date(year, month).toLocaleString('default', { month: 'long' }).toUpperCase()} ${year}`}
                    </div>
                    <table className="table table-bordered text-center">
                        <thead className="table-light">
                            <tr>
                                <th>Sunday</th>
                                <th>Monday</th>
                                <th>Tuesday</th>
                                <th>Wednesday</th>
                                <th>Thursday</th>
                                <th>Friday</th>
                                <th>Saturday</th>
                            </tr>
                        </thead>
                        <tbody>
                            {days.map((week, weekIndex) => (
                                <tr key={weekIndex}>
                                    {week.map((day, dayIndex) => (
                                        <td
                                            key={dayIndex}
                                            className={day ? `p-2 ${day.isSunday ? "bg-light" : ""}` : "p-2"}
                                        >
                                            {day ? (
                                                <>
                                                    <strong>{day.date}</strong>
                                                    <br />
                                                    <small>
                                                        <a href="#" className="text-muted text-decoration-none">New Holiday</a>
                                                    </small>
                                                </>
                                            ) : null}
                                        </td>
                                    ))}
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    );
}

export default Holidays;
