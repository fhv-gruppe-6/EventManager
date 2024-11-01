package at.fhv.se.presentation;

import at.fhv.se.business.AuthorService;
import at.fhv.se.business.dto.AuthorDTO;
import at.fhv.se.presentation.forms.PublicationAssignmentForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Controller
public class PublicationOrganizerController {

    private static final String ALL_AUTHORS_URL = "/";
    private static final String AUTHOR_URL = "/author";
    private static final String PUBLICATION_URL = "/publication";
    private static final String ALL_PUBLICATIONS_URL = "/publications";
    private static final String MANAGE_URL = "/manage";
    private static final String ERROR_URL = "/displayerror";

    private static final String ASSIGN_PUBLICATION_URL = "/manage/assign";

    private static final String ALL_AUTHORS_VIEW = "allAuthors";
    private static final String AUTHOR_VIEW = "authorDetails";
    private static final String PUBLICATIONS_VIEW = "publications";
    private static final String PUBLICATION_VIEW = "publicationDetails";
    private static final String MANAGE_VIEW = "manage";
    private static final String ERROR_VIEW = "errorView";

    // TODO: inject Application Service
    private final AuthorService authorService;

    public PublicationOrganizerController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(ALL_AUTHORS_URL)
    public String allAuthors(Model model) {
        model.addAttribute("authors", authorService.getAuthors());
        return ALL_AUTHORS_VIEW;
    }

    @GetMapping(AUTHOR_URL)
    public ModelAndView authors(@RequestParam("id") String authorId, Model model) {
        // TODO: make a call to an Application Service to get the customer details for customer with customerId
        // TODO: redirect to the error page in case of an error situation - use redirectError("SOME MESSAGE"); for that

        return new ModelAndView(AUTHOR_VIEW);
    }

    @GetMapping(ALL_PUBLICATIONS_URL)
    public String allPublications(Model model) {
        // TODO: make a call to an Application Service to get all Customers
        // TODO: this is fake test data, remove when implementing

        return PUBLICATIONS_VIEW;
    }

    @GetMapping(PUBLICATION_URL)
    public ModelAndView publicationDetails(@RequestParam("id") String publicationId, Model model) {
        // TODO: make a call to an Application Service to get all Customers
        // TODO: this is fake test data, remove when implementing

        return new ModelAndView(PUBLICATION_VIEW);

    }

    @GetMapping(MANAGE_URL)
    public ModelAndView manage(@RequestParam("authorId") String authorId, Model model) {
        // TODO: make a call to an Application Service to get the customer details for customer with customerId
        // TODO: redirect to the error page in case of an error situation - use redirectError("SOME MESSAGE"); for that

        PublicationAssignmentForm form = new PublicationAssignmentForm(Long.valueOf(authorId));

        model.addAttribute("form", form);
        return new ModelAndView(MANAGE_VIEW);
    }


    @PostMapping(ASSIGN_PUBLICATION_URL)
    public ModelAndView assignPublication(
            @ModelAttribute PublicationAssignmentForm form,
            Model model) {
        // TODO: make a call to an Application Service to deposit form.getAmount() into the Account with form.getIban()
        // TODO: redirect to the error page in case of an error situation - use redirectError("SOME MESSAGE"); for that


        return redirectToAuthor(form);
    }

    @GetMapping(ERROR_URL)
    public String displayError(@RequestParam("msg") String msg, Model model) {
        model.addAttribute("msg", msg);
        return ERROR_VIEW;
    }

    // NOTE: used to redirect to an error page displaying an error message
    @SuppressWarnings("unused")
    private static ModelAndView redirectError(String msg) {
        return new ModelAndView("redirect:" + ERROR_URL + "?msg=" + msg);
    }


    private static ModelAndView redirectToAuthor(final PublicationAssignmentForm form) {
        return new ModelAndView("redirect:" +
                AUTHOR_URL +
                "?id=" +
                form.getAuthorId());
    }
}
