import React, { useRef, useState } from "react";
import "../css/LoginForm.css";
import { useNavigate } from "react-router-dom";
import { Buffer } from "buffer";

const url = "http://localhost:8080";

const LoginForm = () => {
  const [login, setLogin] = useState("NOT logged in");
  const [message, setMessage] = useState("");
  const emailRef = useRef();
  const passwordRef = useRef();

  function handleMessage() {
    const uri = url + "/message";
    fetch(uri)
      .then((response) => response.text())
      .then((text) => setMessage(text));
  }

  function handleLogin() {
    const uri = url + "/authentication/login";
    const username = "el@el.el";
    const password = "el";

    const headers = new Headers();
    const auth = Buffer.from(username + ":" + password).toString("base64");
    headers.set("Authorization", "Basic " + auth);
    return fetch(uri, { method: "GET", headers: headers })
      .then((response) => response.text())
      .then((text) => setLogin(text))
      .catch((error) => console.log("ERROR: " + error));
  }

  function submit() {
    const uri = url + "/authentication/login";
    const username = emailRef.current.value;
    const password = passwordRef.current.value;

    const headers = new Headers();
    const auth = Buffer.from(username + ":" + password).toString("base64");
    headers.set("Authorization", "Basic " + auth);
    return fetch(uri, { method: "GET", headers: headers })
      .then((response) => response.text())
      .then((text) => setLogin(text))
      .then(() => {
        emailRef.current.value = "";
        passwordRef.current.value = "";
      })
      .catch((error) => console.log("ERROR: " + error));
  }
  return (
    <>
      <h1>Basic Authentication</h1>
      <button button='button' onClick={handleMessage}>
        Message
      </button>
      <p>{message}</p>
      <button button='button' onClick={handleLogin}>
        Login
      </button>
      <p>{login}</p>
      <form>
        <label for='email'>Email</label>
        <input
          id='email'
          type='email'
          ref={emailRef}
          placeholder='email@example.com'
        ></input>
        <label for='password'>Password</label>
        <input id='password' type='password' ref={passwordRef}></input>
        <button type='button' onClick={submit}>Submit login</button>
      </form>
    </>
  );
};

export default LoginForm;
