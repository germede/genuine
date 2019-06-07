package org.fluentness.renderable;

public interface Renderable extends CharSequence {

    String render();

    @Override
    default int length() {
        return render().length();
    }

    @Override
    default char charAt(int i) {
        return render().charAt(i);
    }

    @Override
    default CharSequence subSequence(int i, int i1) {
        return render().subSequence(i, i1);
    }
}
