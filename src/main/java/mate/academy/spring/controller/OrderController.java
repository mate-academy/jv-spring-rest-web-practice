package mate.academy.spring.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dao.impl.TicketDaoImpl;
import mate.academy.spring.mapper.impl.response.OrderResponseMapper;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.util.HashUtil;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private ShoppingCartService shoppingCartService;
    private OrderService orderService;
    private MovieService movieService;
    private CinemaHallService cinemaHallService;
    private UserService userService;
    private OrderResponseMapper mapper;
    private MovieSessionService movieSessionService;
    private SessionFactory sessionFactory;
    private ShoppingCartService cartService;

    @Autowired
    public OrderController(UserService userService,
                           ShoppingCartService shoppingCartService,
                           OrderService orderService,
                           MovieService movieService,
                           OrderResponseMapper mapper,
                           CinemaHallService cinemaHallService,
                           MovieSessionService movieSessionService,
                           SessionFactory sessionFactory,
                           ShoppingCartService cartService) {
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
        this.movieService = movieService;
        this.userService = userService;
        this.mapper = mapper;
        this.cinemaHallService = cinemaHallService;
        this.movieSessionService = movieSessionService;
        this.sessionFactory = sessionFactory;
        this.cartService = cartService;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        return mapper.toDto(orderService.completeOrder(shoppingCartService
                .getByUser(userService.get(userId))));
    }

    @GetMapping
    public List<OrderResponseDto> get(@RequestParam Long userId) {
        return orderService.getOrdersHistory(userService.get(userId)).stream()
                .map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/init")
    public void initOrder() {
        User oleh = new User();
        oleh.setEmail("blokitin@gmail.com");
        oleh.setPassword("Azunen13");
        oleh.setSalt(HashUtil.getSalt());
        userService.add(oleh);

        User inessa = new User();
        inessa.setEmail("blokitina@gmail.com");
        inessa.setPassword("Azunen13");
        inessa.setSalt(HashUtil.getSalt());
        userService.add(inessa);

        Movie aquamen = new Movie();
        aquamen.setTitle("Aquaman");
        aquamen.setDescription("It's a great aquaman about sea and superhero!");
        movieService.add(aquamen);

        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCapacity(120);
        cinemaHall.setDescription("VIP");
        cinemaHallService.add(cinemaHall);

        MovieSession sessionAquamen = new MovieSession();
        sessionAquamen.setShowTime(LocalDateTime.now());
        sessionAquamen.setMovie(aquamen);
        sessionAquamen.setCinemaHall(cinemaHall);
        movieSessionService.add(sessionAquamen);

        TicketDaoImpl ticketDao = new TicketDaoImpl(sessionFactory);
        Ticket ticketOleh = new Ticket();
        ticketOleh.setUser(oleh);
        ticketOleh.setMovieSession(sessionAquamen);
        ticketDao.add(ticketOleh);

        Ticket ticketInessa = new Ticket();
        ticketInessa.setUser(inessa);
        ticketInessa.setMovieSession(sessionAquamen);
        ticketDao.add(ticketInessa);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(oleh);
        shoppingCart.setTickets(List.of(ticketOleh, ticketInessa));

        cartService.registerNewShoppingCart(oleh);

    }
}
