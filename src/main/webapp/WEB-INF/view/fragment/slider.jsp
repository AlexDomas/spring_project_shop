<%-- 
    Document   : slider.jsp
    Created on : Feb 10, 2022, 11:54:05 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

        <article class="art hidden-xs">

            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                </ol>

                <!-- Wrapper for slides -->

                <div class="carousel-inner">
                    <div class="item active">
                        <img src="/media/zenbook.jpg" alt="" />
                        <div class="container">
                            <div class="carousel-caption">
                                <h1>Asus ZenBook 13 UX325EA-KG262</h1>
                                <p class="lead">The new ZenBook 13 is thinner, lighter and more mobile, while still offering a complete set of interfaces</p>
                            </div>
                        </div>
                    </div>

                    <div class="item">
                        <img src="/media/honor.jpg" alt="" />
                        <div class="container">
                            <div class="carousel-caption">
                                <h1>Honor 20 Pro</h1>
                                <p class="lead">Honor 20 Pro turned out to be more strict and solid than most of its relatives in the Honor family</p>
                            </div>
                        </div>
                    </div>

                    <div class="item">
                        <img src="/media/omega.jpg" alt="" />
                        <div class="container">
                            <div class="carousel-caption">
                                <h1>Bootstrap Carousel Fullscreen</h1>
                                <p class="lead">Just turns the Twitter Bootstrap Carousel in fullscreen mode, and scale to fit the screen resolution</p>
                            </div>
                        </div>
                    </div>

                    <div class="item">
                        <img src="/media/stoneswatch.jpg" alt="" />
                        <div class="container">
                            <div class="carousel-caption">
                                <h1>Bootstrap Carousel Fullscreen</h1>
                                <p class="lead">Just turns the Twitter Bootstrap Carousel in fullscreen mode, and scale to fit the screen resolution</p>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                </a>
                <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                </a>
            </div>

        </article>
