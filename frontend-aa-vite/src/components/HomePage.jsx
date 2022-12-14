import React from "react";
import { Carousel, Container} from "react-bootstrap";

function HomePage () {
    return(
        <Container>
            <Carousel fade>
                <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://www.elpais.com.co/files/article_main/uploads/2020/03/04/5e5fdf478b0ab.jpeg"
                    alt="First slide"
                />
                <Carousel.Caption>
                    <h1>AUTOMOVILES</h1>
                    <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://www.elcarrocolombiano.com/wp-content/uploads/2017/12/20171206-MAZDA-MEJOR-MARCA-DE-AUTOMOVILES-EN-ESTADOS-UNIDOS-02.jpg"
                    alt="Second slide"
                />
        
                <Carousel.Caption>
                    <h3>CAMIONETAS</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                <img
                    className="d-block w-100"
                    src="https://i0.wp.com/periodistas-es.com/wp-content/uploads/2022/09/furgo%CC%81n-citroen.jpg?resize=696%2C392&ssl=1"
                    alt="Third slide"
                />
        
                <Carousel.Caption>
                    <h3>FURGONES</h3>
                    <p>
                    Praesent commodo cursus magna, vel scelerisque nisl consectetur.
                    </p>
                </Carousel.Caption>
                </Carousel.Item>
            </Carousel>
        </Container>

        
    )
}export{HomePage}