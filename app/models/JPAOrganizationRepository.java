package models;

import static java.util.concurrent.CompletableFuture.*;

import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import play.db.jpa.JPAApi;


public class JPAOrganizationRepository implements OrganizationRepository {

	private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public JPAOrganizationRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

	@Override
	public CompletionStage<Organization> add(Organization organization) {
		return supplyAsync(() -> wrap(em -> insert(em, organization)), executionContext);
	}
	@Override
	public CompletionStage<Stream<Organization>> list() {
		return supplyAsync(() -> wrap(em -> list(em)), executionContext);
	}

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private Organization insert(EntityManager em, Organization organization) {
        em.persist(organization);
        return organization;
    }

    private Stream<Organization> list(EntityManager em) {
        List<Organization> Organizations = em.createQuery("select o from Organization o", Organization.class).getResultList();
        return Organizations.stream();
    }

}
