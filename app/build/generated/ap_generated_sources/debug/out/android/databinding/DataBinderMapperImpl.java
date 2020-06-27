package android.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new tanglemaster3D.tangle.guide.DataBinderMapperImpl());
  }
}
