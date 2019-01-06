import cv2
import numpy as np

# 获得视频的格式
videoCapture = cv2.VideoCapture('input.mp4')

# 获得码率及尺寸
fps = videoCapture.get(cv2.CAP_PROP_FPS)
video_width = int(videoCapture.get(cv2.CAP_PROP_FRAME_WIDTH))
video_height = int(videoCapture.get(cv2.CAP_PROP_FRAME_HEIGHT))
size = (video_width + video_height // 4 , video_height)

# 指定写视频的格式, I420-avi, MJPG-mp4
videoWriter = cv2.VideoWriter('output.avi', cv2.VideoWriter_fourcc('X', 'V', 'I', 'D'), fps, size)

# 读帧
success, frame = videoCapture.read()

# 读图片
images_raw = []
images_raw.append(cv2.imread('image1.jpg'))
images_raw.append(cv2.imread('image2.jpg'))
images_raw.append(cv2.imread('image3.jpg'))
images_raw.append(cv2.imread('image4.jpg'))

# 指定拼接后图片大小
pic_width,pic_height = video_height // 4, video_height // 4
images = []
for image in images_raw:
    # 重置每张图大小
    im = cv2.resize(image, (pic_width,pic_height))
    images.append(im)

while success:
    background = np.ones(shape=(video_height, video_width + pic_width, 3), dtype=np.uint8) * 255
    background[0:video_height, 0:video_width, :] = frame
    count = 0
    for image in images:
        background[pic_height*count:pic_height*(count+1), video_width:(video_width + pic_width), :] = image
        count+=1
    
    # cv2.imshow("Oto Video", background)  # 显示
    cv2.waitKey(int(1000 / int(fps)))  # 延迟
    videoWriter.write(background)  # 写视频帧
    success, frame = videoCapture.read()  # 获取下一帧

videoCapture.release()
videoWriter.release()
# cv2.destoryAllWindows()
