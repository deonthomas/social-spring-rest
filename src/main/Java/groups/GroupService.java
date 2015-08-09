package groups;

/**
 * Created by Deon on 4/08/2015.
 */
public interface GroupService {
    Integer saveGroup(Group group);

    Boolean isOwnerOrAdmin(Integer userId, Integer groupId);

    Boolean isMember(Integer userId, Integer groupId);

    Boolean isAdministrator(Integer userId, Integer groupId);

    Boolean isOwner(Integer userId, Integer groupId);
}


