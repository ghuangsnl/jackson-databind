package com.fasterxml.jackson.databind.cfg;

/**
 * @since 2.12
 */
public class CoercionConfig
    implements java.io.Serializable // needed in 3.0 too, still
{
    private static final long serialVersionUID = 3L;

    private final static int INPUT_SHAPE_COUNT = CoercionInputShape.values().length;

    protected Boolean _acceptBlankAsEmpty;

    /**
     * Mapping from {@link CoercionInputShape} into corresponding
     * {@link CoercionAction}.
     */
    protected final CoercionAction[] _coercionsByShape = new CoercionAction[INPUT_SHAPE_COUNT];

    public CoercionConfig() { }

    protected CoercionConfig(CoercionConfig src) {
        _acceptBlankAsEmpty = src._acceptBlankAsEmpty;
    }

    public CoercionAction findAction(CoercionInputShape shape) {
        return _coercionsByShape[shape.ordinal()];
    }

    public Boolean getAcceptBlankAsEmpty() {
        return _acceptBlankAsEmpty;
    }
}
