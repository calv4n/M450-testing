package ch.tbz.m450;

import ch.tbz.m450.repository.Address;
import ch.tbz.m450.repository.AddressRepository;
import ch.tbz.m450.service.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AddressServiceTest {

    private AddressService addressService;
    private AddressRepository addressRepository;

    @BeforeEach
    void setUp() {
        addressRepository = mock(AddressRepository.class);
        addressService = new AddressService(addressRepository);
    }

    @Test
    void testSave() {
        Address address = new Address(1, "John", "Doe", "123456789", new Date());
        when(addressRepository.save(address)).thenReturn(address);

        Address savedAddress = addressService.save(address);

        assertNotNull(savedAddress);
        assertEquals("John", savedAddress.getFirstname());
        verify(addressRepository, times(1)).save(address);
    }

    @Test
    void testGetAll() {
        Address address1 = new Address(1, "Alice", "Smith", "123456", new Date());
        Address address2 = new Address(2, "Bob", "Brown", "789012", new Date());
        List<Address> mockAddresses = Arrays.asList(address2, address1);
        when(addressRepository.findAll()).thenReturn(mockAddresses);

        List<Address> addresses = addressService.getAll();

        assertNotNull(addresses);
        assertEquals(2, addresses.size());
        assertEquals("Bob", addresses.get(0).getFirstname());
        verify(addressRepository, times(1)).findAll();
    }

    @Test
    void testGetAddress_Found() {
        Address address = new Address(1, "Jane", "Doe", "456123", new Date());
        when(addressRepository.findById(1)).thenReturn(Optional.of(address));

        Optional<Address> foundAddress = addressService.getAddress(1);

        assertTrue(foundAddress.isPresent());
        assertEquals("Jane", foundAddress.get().getFirstname());
        verify(addressRepository, times(1)).findById(1);
    }

    @Test
    void testGetAddress_NotFound() {
        when(addressRepository.findById(1)).thenReturn(Optional.empty());

        Optional<Address> foundAddress = addressService.getAddress(1);

        assertFalse(foundAddress.isPresent());
        verify(addressRepository, times(1)).findById(1);
    }
}
