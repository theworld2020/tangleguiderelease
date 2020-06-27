package tanglemaster3D.tangle.guide.databinding;
import tanglemaster3D.tangle.guide.R;
import tanglemaster3D.tangle.guide.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ContentMainBindingImpl extends ContentMainBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.hr, 5);
        sViewsWithIds.put(R.id.hr1, 6);
        sViewsWithIds.put(R.id.recycler_view, 7);
        sViewsWithIds.put(R.id.playprotect, 8);
    }
    // views
    @NonNull
    private final android.support.v4.widget.NestedScrollView mboundView0;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView3;
    @NonNull
    private final android.widget.LinearLayout mboundView4;
    // variables
    // values
    // listeners
    private OnClickListenerImpl mHandlersOnPostsClickedAndroidViewViewOnClickListener;
    private OnLongClickListenerImpl mHandlersOnProfileImageLongPressedAndroidViewViewOnLongClickListener;
    // Inverse Binding Event Handlers

    public ContentMainBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }
    private ContentMainBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TableRow) bindings[5]
            , (android.widget.TableRow) bindings[6]
            , (android.widget.ImageView) bindings[8]
            , (android.widget.ImageView) bindings[1]
            , (android.support.v7.widget.RecyclerView) bindings[7]
            );
        this.mboundView0 = (android.support.v4.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.LinearLayout) bindings[4];
        this.mboundView4.setTag(null);
        this.profileImage.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.user == variableId) {
            setUser((tanglemaster3D.tangle.guide.model.User) variable);
        }
        else if (BR.handlers == variableId) {
            setHandlers((tanglemaster3D.tangle.guide.view.MainActivity.MyClickHandlers) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setUser(@Nullable tanglemaster3D.tangle.guide.model.User User) {
        updateRegistration(0, User);
        this.mUser = User;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.user);
        super.requestRebind();
    }
    public void setHandlers(@Nullable tanglemaster3D.tangle.guide.view.MainActivity.MyClickHandlers Handlers) {
        this.mHandlers = Handlers;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.handlers);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeUser((tanglemaster3D.tangle.guide.model.User) object, fieldId);
        }
        return false;
    }
    private boolean onChangeUser(tanglemaster3D.tangle.guide.model.User User, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        else if (fieldId == BR.profileImage) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        else if (fieldId == BR.name) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        else if (fieldId == BR.about) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        tanglemaster3D.tangle.guide.model.User user = mUser;
        java.lang.String userProfileImage = null;
        android.view.View.OnClickListener handlersOnPostsClickedAndroidViewViewOnClickListener = null;
        java.lang.String userName = null;
        android.view.View.OnLongClickListener handlersOnProfileImageLongPressedAndroidViewViewOnLongClickListener = null;
        tanglemaster3D.tangle.guide.view.MainActivity.MyClickHandlers handlers = mHandlers;
        java.lang.String userAbout = null;

        if ((dirtyFlags & 0x3dL) != 0) {


            if ((dirtyFlags & 0x25L) != 0) {

                    if (user != null) {
                        // read user.profileImage
                        userProfileImage = user.getProfileImage();
                    }
            }
            if ((dirtyFlags & 0x29L) != 0) {

                    if (user != null) {
                        // read user.name
                        userName = user.getName();
                    }
            }
            if ((dirtyFlags & 0x31L) != 0) {

                    if (user != null) {
                        // read user.about
                        userAbout = user.getAbout();
                    }
            }
        }
        if ((dirtyFlags & 0x22L) != 0) {



                if (handlers != null) {
                    // read handlers::onPostsClicked
                    handlersOnPostsClickedAndroidViewViewOnClickListener = (((mHandlersOnPostsClickedAndroidViewViewOnClickListener == null) ? (mHandlersOnPostsClickedAndroidViewViewOnClickListener = new OnClickListenerImpl()) : mHandlersOnPostsClickedAndroidViewViewOnClickListener).setValue(handlers));
                    // read handlers::onProfileImageLongPressed
                    handlersOnProfileImageLongPressedAndroidViewViewOnLongClickListener = (((mHandlersOnProfileImageLongPressedAndroidViewViewOnLongClickListener == null) ? (mHandlersOnProfileImageLongPressedAndroidViewViewOnLongClickListener = new OnLongClickListenerImpl()) : mHandlersOnProfileImageLongPressedAndroidViewViewOnLongClickListener).setValue(handlers));
                }
        }
        // batch finished
        if ((dirtyFlags & 0x29L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, userName);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, userAbout);
        }
        if ((dirtyFlags & 0x22L) != 0) {
            // api target 1

            this.mboundView4.setOnClickListener(handlersOnPostsClickedAndroidViewViewOnClickListener);
            this.profileImage.setOnLongClickListener(handlersOnProfileImageLongPressedAndroidViewViewOnLongClickListener);
        }
        if ((dirtyFlags & 0x25L) != 0) {
            // api target 1

            tanglemaster3D.tangle.guide.model.User.loadImage(this.profileImage, userProfileImage);
        }
    }
    // Listener Stub Implementations
    public static class OnClickListenerImpl implements android.view.View.OnClickListener{
        private tanglemaster3D.tangle.guide.view.MainActivity.MyClickHandlers value;
        public OnClickListenerImpl setValue(tanglemaster3D.tangle.guide.view.MainActivity.MyClickHandlers value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public void onClick(android.view.View arg0) {
            this.value.onPostsClicked(arg0); 
        }
    }
    public static class OnLongClickListenerImpl implements android.view.View.OnLongClickListener{
        private tanglemaster3D.tangle.guide.view.MainActivity.MyClickHandlers value;
        public OnLongClickListenerImpl setValue(tanglemaster3D.tangle.guide.view.MainActivity.MyClickHandlers value) {
            this.value = value;
            return value == null ? null : this;
        }
        @Override
        public boolean onLongClick(android.view.View arg0) {
            return this.value.onProfileImageLongPressed(arg0); 
        }
    }
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): user
        flag 1 (0x2L): handlers
        flag 2 (0x3L): user.profileImage
        flag 3 (0x4L): user.name
        flag 4 (0x5L): user.about
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}