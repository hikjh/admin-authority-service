package com.stable.adminauthorityservice.domain.valueobject;

import java.util.Objects;

public abstract class BaseId<T> {

    private T id;

    public BaseId(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseId<?> baseId = (BaseId<?>) o;
        return id.equals(baseId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
