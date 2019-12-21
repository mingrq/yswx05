package com.chiye.yswx05.common;

import java.util.List;

public class ProductEntity {

    /**
     * product : {"typeName":"热销产品","id":0,"productLists":[{"name":"TMF-DZ直角式电磁脉冲阀","id":11,"litpic":"http://www.hbczdxg.com/uploads/190706/1_0T21T60.jpg","aid":116},{"name":"TMF-Y-89A淹没式电磁脉冲阀","id":11,"litpic":"http://www.hbczdxg.com/uploads/190706/1_0T251918.jpg","aid":115},{"name":"TMF-S80活塞式电磁脉冲阀","id":11,"litpic":"http://www.hbczdxg.com/uploads/190706/1_0T323923.jpg","aid":114},{"name":"氟美斯除尘布袋","id":12,"litpic":"http://www.hbczdxg.com/uploads/190603/1_164F51X.jpg","aid":105},{"name":"防静电除尘布袋","id":12,"litpic":"http://www.hbczdxg.com/uploads/190603/1_164A1493.jpg","aid":104},{"name":"涤纶除尘布袋","id":12,"litpic":"http://www.hbczdxg.com/uploads/190603/1_164619259.jpg","aid":103},{"name":"圆形除尘骨架","id":13,"litpic":"http://www.hbczdxg.com/uploads/190602/1_205923626.jpg","aid":102},{"name":"有机硅除尘骨架","id":13,"litpic":"http://www.hbczdxg.com/uploads/190602/1_205910521.jpg","aid":101},{"name":"星型除尘骨架","id":13,"litpic":"http://www.hbczdxg.com/uploads/190602/1_205UVP.png","aid":100},{"name":"镀锌除尘骨架","id":13,"litpic":"http://www.hbczdxg.com/uploads/190602/1_205P9402.jpg","aid":97}],"size":10}
     */

    private ProductBean product;

    public ProductBean getProduct() {
        return product;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
    }

    public static class ProductBean {
        /**
         * typeName : 热销产品
         * id : 0
         * productLists : [{"name":"TMF-DZ直角式电磁脉冲阀","id":11,"litpic":"http://www.hbczdxg.com/uploads/190706/1_0T21T60.jpg","aid":116},{"name":"TMF-Y-89A淹没式电磁脉冲阀","id":11,"litpic":"http://www.hbczdxg.com/uploads/190706/1_0T251918.jpg","aid":115},{"name":"TMF-S80活塞式电磁脉冲阀","id":11,"litpic":"http://www.hbczdxg.com/uploads/190706/1_0T323923.jpg","aid":114},{"name":"氟美斯除尘布袋","id":12,"litpic":"http://www.hbczdxg.com/uploads/190603/1_164F51X.jpg","aid":105},{"name":"防静电除尘布袋","id":12,"litpic":"http://www.hbczdxg.com/uploads/190603/1_164A1493.jpg","aid":104},{"name":"涤纶除尘布袋","id":12,"litpic":"http://www.hbczdxg.com/uploads/190603/1_164619259.jpg","aid":103},{"name":"圆形除尘骨架","id":13,"litpic":"http://www.hbczdxg.com/uploads/190602/1_205923626.jpg","aid":102},{"name":"有机硅除尘骨架","id":13,"litpic":"http://www.hbczdxg.com/uploads/190602/1_205910521.jpg","aid":101},{"name":"星型除尘骨架","id":13,"litpic":"http://www.hbczdxg.com/uploads/190602/1_205UVP.png","aid":100},{"name":"镀锌除尘骨架","id":13,"litpic":"http://www.hbczdxg.com/uploads/190602/1_205P9402.jpg","aid":97}]
         * size : 10
         */

        private String typeName;
        private int id;
        private int size;
        private List<ProductListsBean> productLists;

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

        public List<ProductListsBean> getProductLists() {
            return productLists;
        }

        public void setProductLists(List<ProductListsBean> productLists) {
            this.productLists = productLists;
        }

        public static class ProductListsBean {
            /**
             * name : TMF-DZ直角式电磁脉冲阀
             * id : 11
             * litpic : http://www.hbczdxg.com/uploads/190706/1_0T21T60.jpg
             * aid : 116
             */

            private String name;
            private int id;
            private String litpic;
            private int aid;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLitpic() {
                return litpic;
            }

            public void setLitpic(String litpic) {
                this.litpic = litpic;
            }

            public int getAid() {
                return aid;
            }

            public void setAid(int aid) {
                this.aid = aid;
            }
        }
    }
}
