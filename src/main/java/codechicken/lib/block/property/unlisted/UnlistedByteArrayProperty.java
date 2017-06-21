package codechicken.lib.block.property.unlisted;

public class UnlistedByteArrayProperty extends UnlistedPropertyBase<byte[]> {

    public UnlistedByteArrayProperty(String name) {
        super(name);
    }

    @Override
    public Class<byte[]> getType() {
        return byte[].class;
    }

	@Override
	public String valueToString(byte[] value) {
		return null;
	}

    /*@Override
    public String valueToString(byte[] value) {
        ToStringBuilder helper = Objects.class.getName();
        if (value != null) {
            for (int i1 = 0; i1 < value.length; i1++) {
                byte i = value[i1];
                helper.append("Index:" + i1, i);
            }
        }
        return helper.toString();
    }*/
}
