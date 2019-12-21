package com.chiye.yswx05.ui.home;

import java.util.List;

public class RcyBtnEntity {

    private List<ProductsBean> products;

    public List<ProductsBean> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsBean> products) {
        this.products = products;
    }

    public static class ProductsBean {
        /**
         * typeName : 除尘布袋
         * id : 12
         * size : 0
         */

        private String typeName;
        private int id;
        private int size;

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }
}
