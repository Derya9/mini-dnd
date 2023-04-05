import RegistrationForm from "./RegistrationForm";

const Header = () => {


    return (
        <nav className="header">
            <div className="links">
                <a href={"/auth/login"}>
                    <button className="log-in-button">Login</button>
                </a>
                <a href={"/auth/registration"}>
                    <button className="sign-up-button" >Sign Up</button>
            </a>
                <a href={"/"}>
                    <button>Home</button>
                </a>
            </div>
        </nav>);
}

export default Header;