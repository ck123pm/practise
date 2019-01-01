from os import listdir
from PIL import Image, ImageDraw

def batchCut(images):
    (width, height) = images[0].size
    # 定义空白长图片
    result = Image.new(images[0].mode, (width, height * len(images)))
    # 拼接
    for i, im in enumerate(images):
        im = im.resize(images[0].size, Image.ANTIALIAS)
        result.paste(im, box=(0, i * height))
    # 保存图片
    result.save('Output/result.jpg')


def addBorder(image):
    width, height = image.size
    border_width = width + 20
    border_height = height + 20
    image_border = Image.new(image.mode, (border_width, border_height))
    draw = ImageDraw.ImageDraw(image_border)
    draw.rectangle([(0, 0), (border_width, border_height)], fill='#ffffff', width=10)

    image_border.paste(image, box=(10, 10))
    return image_border


if __name__ == '__main__':
    # 从当前路径拿到这几种后缀的文件
    images = []
    for fn in listdir():
        if fn.endswith(('.jpg', '.png', '.JEPG')):
            im = Image.open(fn)
            # 给图像加上边框
            im = addBorder(im)
            images.append(im)
    # 拼接图片
    batchCut(images)