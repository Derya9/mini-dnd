import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import Header from "./components/Header";
import Footer from "./components/Footer";
import LandingPage from "./components/LandingPage";
import CharacterForm from "./components/CharacterForm";
import CharacterDetails from "./components/CharacterDetails";
import UpdateCharacter from "./components/UpdateCharacter";
import RegistrationForm from "./components/RegistrationForm";
import LoginForm from "./components/LoginForm";


function App() {
    return (
        <Router>
            <div className="App">
                <div className="content">
                    <Header/>
                    <Routes>
                        <Route path="/" exact element={<LandingPage/>}/>
                        <Route path="/characters/add" element={<CharacterForm/>}/>
                        <Route path="/characters/:id" element={<CharacterDetails/>}/>
                        <Route path="/characters/:id/update" element={<UpdateCharacter/>}/>
                        <Route path="/auth/registration" element={<RegistrationForm/>}/>
                        <Route path="/auth/login" element={<LoginForm/>}/>
                    </Routes>
                    <Footer/>
                </div>
            </div>
        </Router>
    );
}

export default App;
