package seedu.loyaltylift.model.order;

import static seedu.loyaltylift.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDate;
import java.util.Objects;

import seedu.loyaltylift.model.customer.Customer;

import seedu.loyaltylift.model.attribute.Address;
import seedu.loyaltylift.model.attribute.Name;

/**
 * Represents an Order in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Order {

    private final Customer customer;
    private final Name name;
    private final Quantity quantity;
    private final Status status;
    private final Address address;
    private final CreatedDate createdDate;

    /**
     * Order constructor with created date set to today.
     */
    public Order(Customer customer, Name name, Quantity quantity, Status status, Address address) {
        this(customer, name, quantity, status, address, new CreatedDate(LocalDate.now()));
    }

    /**
     * Every field must be present and not null.
     */
    public Order(Customer customer, Name name, Quantity quantity, Status status, Address address,
                 CreatedDate createdDate) {
        requireAllNonNull(customer, name, quantity, status, address, createdDate);
        this.customer = customer;
        this.name = name;
        this.quantity = quantity;
        this.status = status;
        this.address = address;
        this.createdDate = createdDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Name getName() {
        return name;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public Status getStatus() {
        return status;
    }

    public Address getAddress() {
        return address;
    }

    public CreatedDate getCreatedDate() {
        return createdDate;
    }

    /**
     * Returns true if both orders have the same name.
     * This defines a weaker notion of equality between two orders.
     */
    public boolean isSameOrder(Order otherOrder) {
        return equals(otherOrder);
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Order)) {
            return false;
        }

        Order otherPerson = (Order) other;
        return otherPerson.getName().equals(getName())
                && otherPerson.getQuantity().equals(getQuantity())
                && otherPerson.getStatus().equals(getStatus())
                && otherPerson.getAddress().equals(getAddress())
                && otherPerson.getCreatedDate().equals(getCreatedDate())
                && otherPerson.customer.equals(getCustomer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, name, quantity, status, address, createdDate);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Quantity: ")
                .append(getQuantity())
                .append("; Status: ")
                .append(getStatus())
                .append("; Address: ")
                .append(getAddress())
                .append("; CreatedDate: ")
                .append(getCreatedDate());
        return builder.toString();
    }

}
