package at.fhv.se.presentation.forms;

public final class PublicationAssignmentForm {
    private Long authorId;
    private Long publicationId;

    public PublicationAssignmentForm() {
    }

    public PublicationAssignmentForm(Long authorId) {
        this.authorId = authorId;
    }

    public PublicationAssignmentForm(Long authorId, Long publicationId) {
        this.authorId = authorId;
        this.publicationId = publicationId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getPublicationId() {
        return publicationId;
    }

    public void setPublicationId(Long publicationId) {
        this.publicationId = publicationId;
    }
}
