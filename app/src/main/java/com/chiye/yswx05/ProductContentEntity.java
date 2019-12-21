package com.chiye.yswx05;

public class ProductContentEntity {

    /**
     * productDetail : {"id":100,"name":"星型除尘骨架","litpic":"http://www.hbczdxg.com/uploads/190602/1_205UVP.png","detail":"<p><\/p><p><\/p><p style=text-align:center><\/p><p><\/p><p>普通除尘骨架的内圈是圆型的，星型除尘骨架的内圈提带星角(像五星一样，但是角比五星要多)，清灰时利用阀门逐室切换，形成逆向气流反吹，使滤袋缩瘪或膨胀清灰的。星角骨架在除尘器布袋缩瘪有效，除尘布袋被吹起膨胀的粗大，在气流的情况下动作大，清灰效果好。<\/p><p>原料<\/p><p>低碳钢丝、镀锌钢丝、不锈钢线材。<\/p><p>表面处理<\/p><p>有镀锌、喷塑、防腐处理、表面有机硅喷涂等。<\/p><p>产品特点<\/p><p>造价低，安装方便，重量轻，采用专用设备一次焊接成型，星型除尘骨架是滤袋的肋骨，骨架的质量直接影响滤袋的工作状态与使用寿命，降低了设备价格，是用户理想的锅炉除尘配套产品。<\/p><p>工作原理<\/p><p>将压缩空气在极短暂的时间内高速喷向除尘滤袋，同时诱导数倍于喷射气量的空气形成空气波，使滤袋由袋口至底部产生急剧的膨胀和冲击振动，在短促的时间内形成滤袋往复地鼓、瘪、鼓的波浪形变形，使粉尘层发生变形、断裂，以块团状脱离滤布并受重力作用下落。清灰时，清灰气流在使滤袋膨胀变形的同时也穿过袋壁和粉尘层。<\/p><p><br/><\/p><p><\/p>"}
     */

    private ProductDetailBean productDetail;

    public ProductDetailBean getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetailBean productDetail) {
        this.productDetail = productDetail;
    }

    public static class ProductDetailBean {
        /**
         * id : 100
         * name : 星型除尘骨架
         * litpic : http://www.hbczdxg.com/uploads/190602/1_205UVP.png
         * detail : <p></p><p></p><p style=text-align:center></p><p></p><p>普通除尘骨架的内圈是圆型的，星型除尘骨架的内圈提带星角(像五星一样，但是角比五星要多)，清灰时利用阀门逐室切换，形成逆向气流反吹，使滤袋缩瘪或膨胀清灰的。星角骨架在除尘器布袋缩瘪有效，除尘布袋被吹起膨胀的粗大，在气流的情况下动作大，清灰效果好。</p><p>原料</p><p>低碳钢丝、镀锌钢丝、不锈钢线材。</p><p>表面处理</p><p>有镀锌、喷塑、防腐处理、表面有机硅喷涂等。</p><p>产品特点</p><p>造价低，安装方便，重量轻，采用专用设备一次焊接成型，星型除尘骨架是滤袋的肋骨，骨架的质量直接影响滤袋的工作状态与使用寿命，降低了设备价格，是用户理想的锅炉除尘配套产品。</p><p>工作原理</p><p>将压缩空气在极短暂的时间内高速喷向除尘滤袋，同时诱导数倍于喷射气量的空气形成空气波，使滤袋由袋口至底部产生急剧的膨胀和冲击振动，在短促的时间内形成滤袋往复地鼓、瘪、鼓的波浪形变形，使粉尘层发生变形、断裂，以块团状脱离滤布并受重力作用下落。清灰时，清灰气流在使滤袋膨胀变形的同时也穿过袋壁和粉尘层。</p><p><br/></p><p></p>
         */

        private int id;
        private String name;
        private String litpic;
        private String detail;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLitpic() {
            return litpic;
        }

        public void setLitpic(String litpic) {
            this.litpic = litpic;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }
}
