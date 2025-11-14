package ch.tbz.m450;

import ch.tbz.m450.controller.AddressController;
import ch.tbz.m450.repository.Address;
import ch.tbz.m450.service.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.*;

public class AddressControllerTest {
    private AddressController addressController;
    private AddressService addressService;

    @BeforeEach
    void setUp() {
        addressService = mock(AddressService.class);
        addressController = new AddressController(addressService);
    }

    @Test
    void testCreateAddress() {
        Address mockAddress = new Address(1, "Street", "City", "1234", new java.util.Date());
        when(addressService.save(Mockito.any(Address.class))).thenReturn(mockAddress);

        Address newAddress = new Address(0, "New Street", "New City", "5678", new java.util.Date());
        ResponseEntity<Address> response = addressController.createAddress(newAddress);

        assertNotNull(response);
        assertEquals(CREATED, response.getStatusCode());
        assertEquals(mockAddress, response.getBody());
        verify(addressService, times(1)).save(newAddress);
    }

    @Test
    void testGetAddresses() {
        List<Address> mockAddresses = Arrays.asList(
                new Address(1, "Street1", "City1", "1234", new java.util.Date()),
                new Address(2, "Street2", "City2", "5678", new java.util.Date())
        );
        when(addressService.getAll()).thenReturn(mockAddresses);

        ResponseEntity<List<Address>> response = addressController.getAddresses();

        assertNotNull(response);
        assertEquals(OK, response.getStatusCode());
        assertEquals(mockAddresses, response.getBody());
        verify(addressService, times(1)).getAll();
    }

    @Test
    void testGetAddress_Found() {
        Address mockAddress = new Address(1, "Street1", "City1", "1234", new java.util.Date());
        when(addressService.getAddress(1)).thenReturn(Optional.of(mockAddress));

        ResponseEntity<Address> response = addressController.getAddress(1);

        assertNotNull(response);
        assertEquals(OK, response.getStatusCode());
        assertEquals(mockAddress, response.getBody());
        verify(addressService, times(1)).getAddress(1);
    }

    @Test
    void testGetAddress_NotFound() {
        when(addressService.getAddress(1)).thenReturn(Optional.empty());

        ResponseEntity<Address> response = addressController.getAddress(1);

        assertNotNull(response);
        assertEquals(NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
        verify(addressService, times(1)).getAddress(1);
    }
}
