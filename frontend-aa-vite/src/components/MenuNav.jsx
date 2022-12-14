import React from "react";
import { Link } from "react-router-dom";

function MenuNav(){
    
    return(
        <div>
            <ul>
                <li>
                    <Link to="/">Inicio</Link>
                </li>
                <li>
                    <Link to="/contacto">Contacto</Link>
                </li>
                <li>
                     <Link to="/blog">Blog</Link>
                </li>
            </ul>
        </div>
    )
}export{MenuNav}
