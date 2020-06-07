package com.lpras.lombok.converters;

public interface Converter<S,D> {
    public D convert(S s);
}
