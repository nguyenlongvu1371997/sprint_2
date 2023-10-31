import React, { useEffect, useState } from 'react';
import Header from './Header';
import "../css/seats.css"
import { Await, useNavigate, useParams } from 'react-router-dom';
import { getSeatByShowtimeId } from '../service/SeatService';
import { getShowtimeById } from '../service/ShowtimesService';
import { getTicket } from '../service/Ticket';
import Swal from 'sweetalert2';

export default function Seats() {
    const params = useParams();
    const [showtime, setShowtime] = useState({});
    const [rows, setRows] = useState([]);
    const [selected, setSelected] = useState([]);
    const [checkout, setCheckout] = useState(false);
    const [price, setPrice] = useState(0);
    const [totalPrice, setTotalPrice] = useState(0);
    const navigate = useNavigate();
    let stateButton = 0


    useEffect(() => {
        getRows();
        getShowtime();

    }, [])

    useEffect(() => {
        getPrice();
    }, [showtime])

    useEffect(() => {
        setTotalPrice((pre) => price * selected.length)
    }, [selected])

    const getPrice = () => {
        const day = new Date(showtime.timeShow);
        if (showtime.timeShow) {
            const options = { weekday: 'long' };
            const date = day.toLocaleString('en-US', options);
            if (date === "Saturday" || date === "Sunday") {
                setPrice(2.5);
            } else {
                setPrice(2);
            }
        }
    }




    const getRows = async () => {
        const res = await getSeatByShowtimeId(params.id);
        setRows((pre) => res);
    }

    const getShowtime = async () => {
        const res = await getShowtimeById(params.id);
        setShowtime((pre) => res);
    }

    const deleteSeatFromSelected = (id) => {
        const list = selected.filter(seat => seat.id !== id);
        setSelected((pre) => list);
        console.log("abc")
        // var colorBox = document.getElementById(id);
        // colorBox.style.backgroundColor = 'red';
    }

    const selectSeat = (choice) => {
        for (let i = 0; i < selected.length; i++) {
            if (choice.id === selected[i].id) {
                deleteSeatFromSelected(choice.id);
                return;
            }
        }
        const list = [...selected, choice];
        setSelected((pre) => list);
        // var colorBox = document.getElementById(choice.id);
        // colorBox.style.backgroundColor = 'white';
    }

    const buyTicket = async () => {
        const list = selected.map((e) => e.id);
        const res = getTicket(list);
         return res;
    }


    const renderPaypalButton = () => {
        const createOrder = (data, actions) => {
            try {
               
               
                return actions.order.create({
                    purchase_units: [
                        {
                            amount: {
                                currency_code: "USD",
                                value: totalPrice
                            },
                        },
                    ],
                });
            } catch (error) {
                console.error("Error creating order:", error);
                throw error;
            }
        };
        window.paypal
            .Buttons({
                style: {
                    color: "gold",
                    layout: "vertical",
                    shape: "rect",
                    label: "pay",
                    height: 40,
                    marginLeft: 400,
                },
                createOrder: createOrder,
                onApprove: async (data, actions) => {
                
                    const res = buyTicket();
                    console.log(res);
                    if (true) {
                        Swal.fire({
                            icon: "success",
                            title: "Payment success",
                            timer: 3000,
                        });
                        navigate("/home");
                    } else {
                        Swal.fire({
                            icon: "error",
                            title: "Payment Failed",
                            timer: 3000,
                        });
                        navigate("/home");
                    }
                },
            })
            .render("#paypal-button-container");
    };
    const handlePayment = () => {
        Swal.fire({
            icon: "warning",
            text: "Are you sure to check out ?",
            showCancelButton: true,
            showConfirmButton: true,
            confirmButtonColor: "#FFC439",
            cancelButtonColor: "grey",
            confirmButtonText: "Yes",
            cancelButtonText: "Not yet",
        }).then((result) => {
            if (result && result.value) {
                if (stateButton === 0) {
                    renderPaypalButton();
                    
                    stateButton++;
                    const kiemTraButton = document.querySelector(
                        "#paypal-button-container button"
                    );
                    kiemTraButton.style.display = "none";
                }
            }
        });
    };








    return (
        <>
            <Header />
            <div className='row'>

                <div className='col-6'>
                    <div className='d-flex justify-content-center'>
                        <div className="screen text-dark text-center fs-5 rounded" style={{ height: '2rem', width: '75%', marginTop: '200px', }}>Screen</div>
                    </div>
                    {rows.map((seats, index) => (
                        <Row key={index} seats={seats} selectSeat={selectSeat} selected={selected} />
                    ))}
                </div>
                <div className='col-6'>
                    <div style={{ height: '200px' }}>
                    </div>
                    <div>
                        <div className=' d-flex justify-content-around'>
                            <div className='d-flex align-items-center'>
                                <p className='seat bg-secondary ' />
                                <span>&nbsp;reversed</span>
                            </div>
                            <div className='d-flex align-items-center'>
                                <p className='seat' />
                                <span>&nbsp; available</span>
                            </div>
                            <div className='d-flex align-items-center'>
                                <p className='seat bg-white' />
                                <span>&nbsp; selected</span>
                              
                            </div>
  
                        </div>
                        <div>
                            {selected.map((seat) => (
                                <span>{seat.name}</span>
                            ))}
                        </div>
                        <div>
                           
                        </div>
                    </div>

                    <h3 className='text-center'>Total price: {totalPrice} USD</h3>
                    <div id="paypal-button-container">
                                    <button style={{ width: '100%', border: '1px' }}
                                        onClick={() => handlePayment()}
                                        className=" btn btn-primary py-3 px-4 text-center"
                                    >
                                        Proceed to Checkout
                                    </button>
                                </div>
                </div>
              
            </div>
        </>
    )
}

function Seat(props) {
    const checkSeatSelect = (id) => {
        for (let i = 0; i < props.selected.length; i++) {
            if (id == props.selected[i].id) {
                return true;
            }
        }
        return false;
    }

    const handleClick = () => {
        props.selectSeat(props.seatId);
    };

    if (!props.seatId.available) {
        return (
            <p className="seat bg-secondary" id={props.seatId} >
                {props.seatId.name}
            </p>
        )
    }
    else {
        if (checkSeatSelect(props.seatId.id)) {

            return (
                <p className="seat bg-light" id={props.seatId} onClick={() => handleClick()}>
                    {props.seatId.name}
                </p>
            )
        } else {
            return (
                <p className="seat" id={props.seatId} onClick={() => handleClick()}>
                    {props.seatId.name}
                </p>
            )
        }
    }
}

function Row(props) {

    return (
        <div className="row">
            {props.seats.map((seat) => (
                <Seat key={seat} seatId={seat} selectSeat={props.selectSeat} selected={props.selected} />
            ))}
        </div>
    );
}