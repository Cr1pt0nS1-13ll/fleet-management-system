import { useState } from "react";

import {
    Box,
    Button,
    TextField,
    Typography,
    Paper,
    CircularProgress
} from "@mui/material";

// Nossa instância do Axios.
// Ela já sabe que o backend está em:
// http://localhost:8080
import api from "../services/api";

function Login() {

    // ======================================================
    // STATES
    // ======================================================

    // Guarda o usuário digitado.
    const [username, setUsername] = useState("");

    // Guarda a senha digitada.
    const [password, setPassword] = useState("");

    // Controla se existe erro de autenticação.
    // false = sem erro
    // true = usuário/senha inválidos
    const [loginError, setLoginError] = useState(false);

    // Controla se o sistema está aguardando
    // resposta do backend.
    const [loading, setLoading] = useState(false);

    // ======================================================
    // LOGIN
    // ======================================================

    function handleLogin() {

        // Evita clicar várias vezes no botão.
        setLoading(true);

        // Limpa mensagens de erro anteriores.
        setLoginError(false);

        api.post("/auth/login", {

            username,
            password

        })

            .then(response => {

                // Recebe o JWT devolvido pelo backend.
                const token = response.data.token;

                // Salva o JWT no navegador.
                localStorage.setItem(
                    "token",
                    token
                );

                // Recarrega a aplicação.
                // O App.tsx perceberá que existe
                // um token salvo e abrirá o sistema.
                window.location.href = "/";

            })

            .catch(error => {

                console.error(
                    "Erro no login:",
                    error
                );

                // Mostra erro abaixo do campo senha.
                setLoginError(true);

                // Reabilita o botão.
                setLoading(false);

            });

    }

    // ======================================================
    // INTERFACE
    // ======================================================

    return (

        <Box

            sx={{

                // Centraliza o login na tela.
                height: "100vh",

                display: "flex",

                justifyContent: "center",

                alignItems: "center",

                // Cor de fundo suave.
                backgroundColor: "#f3f6fb"

            }}

        >

            <Paper

                elevation={8}

                sx={{

                    width: 420,

                    padding: 5,

                    borderRadius: 3

                }}

            >

                {/* ===============================
                    TÍTULO
                   =============================== */}

                <Typography

                    variant="h3"

                    align="center"

                    sx={{

                        fontWeight: "bold",

                        color: "#1565C0"

                    }}

                >

                    RODO

                </Typography>

                <Typography

                    align="center"

                    color="text.secondary"

                    sx={{

                        mb: 4,

                        fontSize: "1rem"

                    }}

                >

                    Gestão Inteligente de Frotas

                </Typography>

                {/* ===============================
                    USUÁRIO
                   =============================== */}

                <TextField

                    fullWidth

                    label="Usuário"

                    margin="normal"

                    value={username}

                    onChange={(e) => {

                        setUsername(e.target.value);

                        // Remove o erro enquanto digita.
                        setLoginError(false);

                    }}

                />

                {/* ===============================
                    SENHA
                   =============================== */}

                <TextField

                    fullWidth

                    label="Senha"

                    type="password"

                    margin="normal"

                    value={password}

                    // Borda vermelha quando houver erro.
                    error={loginError}

                    // Mensagem abaixo da caixa.
                    helperText={

                        loginError

                            ?

                            "Usuário ou senha incorretos."

                            :

                            ""

                    }

                    onChange={(e) => {

                        setPassword(e.target.value);

                        // Remove a mensagem ao voltar a digitar.
                        setLoginError(false);

                    }}

                    // ENTER faz login.
                    onKeyDown={(e) => {

                        if (e.key === "Enter") {

                            handleLogin();

                        }

                    }}

                />

                {/* ===============================
                    BOTÃO
                   =============================== */}

                <Button

                    fullWidth

                    variant="contained"

                    sx={{

                        mt: 3,

                        height: 48,

                        fontWeight: "bold"

                    }}

                    onClick={handleLogin}

                    disabled={loading}

                >

                    {

                        loading

                            ?

                            <CircularProgress

                                size={24}

                                color="inherit"

                            />

                            :

                            "Entrar"

                    }

                </Button>

            </Paper>

        </Box>

    );

}

export default Login;