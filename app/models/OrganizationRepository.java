package models;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

import com.google.inject.ImplementedBy;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 */
@ImplementedBy(JPAOrganizationRepository.class)
public interface OrganizationRepository {

    CompletionStage<Organization> add(Organization organization);

    CompletionStage<Stream<Organization>> list();
}
