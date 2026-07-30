import { useEffect, useState } from "react";
import {
    Paper,
    Typography,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow
} from "@mui/material";

import api from "../services/api";


interface Vehicle {

    id: number;
    nome: string;
    placa: string;
    modelo: string;
    driverId: number;

}




function Vehicles() {

    const [vehicles, setVehicles] = useState<Vehicle[]>([]);


    useEffect(() => {

        api.get("/vehicles")
            .then(response => {

                setVehicles(response.data);

            })
            .catch(error => {

                console.error("Erro ao buscar veículos:", error);

            });


    }, []);



    return (

        <>

            <Typography variant="h4" gutterBottom>
                Veículos
            </Typography>


            <TableContainer component={Paper}>

                <Table>

                    <TableHead>

                        <TableRow>

                            <TableCell>
                                Nome
                            </TableCell>

                            <TableCell>
                                Placa
                            </TableCell>

                            <TableCell>
                                Modelo
                            </TableCell>

                            <TableCell>
                                Motorista
                            </TableCell>
                        </TableRow>

                    </TableHead>


                    <TableBody>

                        {vehicles.map((vehicle) => (

                            <TableRow key={vehicle.id}>

                                <TableCell>
                                    {vehicle.nome}
                                </TableCell>

                                <TableCell>
                                    {vehicle.placa}
                                </TableCell>

                                <TableCell>
                                    {vehicle.modelo}
                                </TableCell>

                                <TableCell>
                                    {vehicle.driverId}
                                </TableCell>


                            </TableRow>

                        ))}


                    </TableBody>


                </Table>


            </TableContainer>


        </>

    );

}


export default Vehicles;