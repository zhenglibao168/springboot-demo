package cn.zlb;

public class DelegateUserDTOBuilder {
    private UserDTO userDTO;

    public DelegateUserDTOBuilder buildUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
        return this;
    }

    public Object createDelegateUserDTO() {
        return new DelegateUserDTO(userDTO);
    }
}