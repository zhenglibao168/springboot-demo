package cn.zlb;

public class DelegateUserDTO {
    private final UserDTO userDTO;

    public DelegateUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    private String demo(UserDTO.AddressDTO addressDTO) {
        String test = userDTO.test(addressDTO.getAddress(), addressDTO.getName(), userDTO.getNewAddress());
        System.out.println(UserDTO.ID_NUMBER);
        return null;
    }
}