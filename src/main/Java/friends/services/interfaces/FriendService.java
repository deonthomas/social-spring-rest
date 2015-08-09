package friends.services.interfaces;

import domain.User;

import java.util.UUID;

public interface FriendService {
    Boolean isFriend(User user, User userBeingViewed);

    Boolean createFriendFromFriendInvitation(UUID invitationKey, User invitationTo);
}
