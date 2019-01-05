package controllers;

import static play.libs.Json.*;

import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import javax.inject.Inject;

import models.Organization;
import models.OrganizationRepository;
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * The controller keeps all database operations behind the repository, and uses
 * {@link play.libs.concurrent.HttpExecutionContext} to provide access to the
 * {@link play.mvc.Http.Context} methods like {@code request()} and {@code flash()}.
 */
public class JpaDBController extends Controller {

    private final FormFactory formFactory;
    private final OrganizationRepository organizationRepository;
    private final HttpExecutionContext ec;

    @Inject
    public JpaDBController(FormFactory formFactory, OrganizationRepository organizationRepository, HttpExecutionContext ec) {
        this.formFactory = formFactory;
        this.organizationRepository = organizationRepository;
        this.ec = ec;
    }

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.jpadb.render());
    }

    public CompletionStage<Result> addOrganization() {
    	Organization organization = formFactory.form(Organization.class).bindFromRequest().get();
        return organizationRepository.add(organization).thenApplyAsync(p -> {
            return redirect(routes.JpaDBController.index());
        }, ec.current());
    }

    public CompletionStage<Result> getOrganizations() {
        return organizationRepository.list().thenApplyAsync(organizationStream -> {
            return ok(toJson(organizationStream.collect(Collectors.toList())));
        }, ec.current());
    }

}
