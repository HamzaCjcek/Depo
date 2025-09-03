/**
 * CoolAdmin Main JavaScript - Vanilla JS Version
 * Backend veri entegrasyonu ile
 */

(() => {
    "use strict";

    try {
        // ---------------- WidgetChart 1 ----------------
        var ctx1 = document.getElementById("widgetChart1");
        if (ctx1) {
            new Chart(ctx1, {
                type: 'line',
                data: {
                    labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                    datasets: [{
                        data: [78, 81, 80, 45, 34, 12, 40],
                        label: 'Dataset',
                        backgroundColor: 'rgba(255,255,255,.1)',
                        borderColor: 'rgba(255,255,255,.55)',
                    }]
                },
                options: {
                    maintainAspectRatio: false,
                    aspectRatio: 2,
                    plugins: { legend: { display: false } },
                    layout: { padding: { left: 0, right: 0, top: 0, bottom: 0 } },
                    responsive: true,
                    scales: {
                        x: { grid: { color: 'transparent' }, ticks: { font: { size: 2 }, color: 'transparent' } },
                        y: { display: false, ticks: { display: false } }
                    },
                    elements: { line: { borderWidth: 0 }, point: { radius: 0, hitRadius: 10, hoverRadius: 4 } }
                }
            });
        }

        // ---------------- WidgetChart 2 ----------------
        var ctx2 = document.getElementById("widgetChart2");
        if (ctx2) {
            ctx2.height = 130;
            new Chart(ctx2, {
                type: 'line',
                data: {
                    labels: ['January', 'February', 'March', 'April', 'May', 'June'],
                    datasets: [{
                        data: [1, 18, 9, 17, 34, 22],
                        label: 'Dataset',
                        backgroundColor: 'transparent',
                        borderColor: 'rgba(255,255,255,.55)',
                    }]
                },
                options: {
                    maintainAspectRatio: false,
                    plugins: {
                        legend: { display: false },
                        tooltip: {
                            mode: 'index',
                            titleFont: { size: 12, family: 'Poppins' },
                            titleColor: '#000',
                            bodyColor: '#000',
                            bodyFont: { family: 'Poppins' },
                            backgroundColor: '#fff',
                            cornerRadius: 3,
                            intersect: false,
                        }
                    },
                    responsive: true,
                    scales: {
                        x: { grid: { color: 'transparent' }, ticks: { font: { size: 2 }, color: 'transparent' } },
                        y: { display: false, ticks: { display: false } }
                    },
                    elements: { line: { tension: 0.00001, borderWidth: 1 }, point: { radius: 4, hitRadius: 10, hoverRadius: 4 } }
                }
            });
        }

        // ---------------- WidgetChart 3 ----------------
        var ctx3 = document.getElementById("widgetChart3");
        if (ctx3) {
            ctx3.height = 130;
            new Chart(ctx3, {
                type: 'line',
                data: {
                    labels: ['January', 'February', 'March', 'April', 'May', 'June'],
                    datasets: [{
                        data: [65, 59, 84, 84, 51, 55],
                        label: 'Dataset',
                        backgroundColor: 'transparent',
                        borderColor: 'rgba(255,255,255,.55)',
                    }]
                },
                options: {
                    maintainAspectRatio: false,
                    plugins: {
                        legend: { display: false },
                        tooltip: {
                            mode: 'index',
                            titleFont: { size: 12, family: 'Poppins' },
                            titleColor: '#000',
                            bodyColor: '#000',
                            backgroundColor: '#fff',
                            bodyFont: { family: 'Poppins' },
                            cornerRadius: 3,
                            intersect: false,
                        }
                    },
                    responsive: true,
                    scales: {
                        x: { grid: { color: 'transparent' }, ticks: { font: { size: 2 }, color: 'transparent' } },
                        y: { display: false, ticks: { display: false } }
                    },
                    elements: { line: { borderWidth: 1 }, point: { radius: 4, hitRadius: 10, hoverRadius: 4 } }
                }
            });
        }

        (async () => {
            // Her chart için konfigürasyon
            const chartConfigs = [
                {
                    canvasId: "recent-rep-chart-1",
                    queries: [
                        { urunId: 1, yil: 2021 },
                        { urunId: 2, yil: 2021 },
                        { urunId: 3, yil: 2021 },
                        { urunId: 4, yil: 2021 },
                    ]
                },
                {
                    canvasId: "recent-rep-chart-2",
                    queries: [
                        { urunId: 1, yil: 2022 },
                        { urunId: 2, yil: 2022 },
                        { urunId: 3, yil: 2022 },
                        { urunId: 4, yil: 2022 }
                    ]
                },
                {
                    canvasId: "recent-rep-chart-3",
                    queries: [
                        { urunId: 1, yil: 2023 },
                        { urunId: 2, yil: 2023 },
                        { urunId: 3, yil: 2023 },
                        { urunId: 4, yil: 2023 }
                    ]
                },
                {
                    canvasId: "recent-rep-chart-4",
                    queries: [
                        { urunId: 1, yil: 2024 },
                        { urunId: 2, yil: 2024 },
                        { urunId: 3, yil: 2024 },
                        { urunId: 4, yil: 2024 }
                    ]
                },
                {
                    canvasId: "recent-rep-chart-5",
                    queries: [
                        { urunId: 1, yil: 2025 },
                        { urunId: 2, yil: 2025 },
                        { urunId: 3, yil: 2025 },
                        { urunId: 4, yil: 2025 }
                    ]
                }
            ];

            const colors = [
                '#fa4251', '#00b5e9', '#28a745', '#ffc107',
                '#6f42c1', '#17a2b8', '#ff5733', '#20c997'
            ];

            for (const config of chartConfigs) {
                const ctx = document.getElementById(config.canvasId);
                if (!ctx) continue;

                const datasets = [];
                let chartLabels = [];

                for (let i = 0; i < config.queries.length; i++) {
                    const { urunId, yil } = config.queries[i];
                    const response = await fetch(`/api/stok/${urunId}/${yil}`);
                    const data = await response.json();

                    const labels = data.map(item => item.ay);
                    const values = data.map(item => item.tuketim);

                    if (i === 0) {
                        chartLabels = labels; // ilk sorgudan ay bilgisi
                    }

                    datasets.push({
                        label: `Ürün ${urunId} - ${yil}`,
                        data: values,
                        borderColor: colors[i % colors.length],
                        backgroundColor: colors[i % colors.length] + "66",
                        borderWidth: 2,
                        tension: 0.3,
                        pointHoverBackgroundColor: "#fff"
                    });
                }

                new Chart(ctx, {
                    type: 'line',
                    data: {
                        labels: chartLabels,
                        datasets: datasets
                    },
                    options: {
                        responsive: true,
                        maintainAspectRatio: false,
                        plugins: {
                            legend: {
                                display: true,
                                position: 'top',
                                labels: { usePointStyle: true, padding: 15, font: { size: 12 } }
                            }
                        },
                        scales: {
                            x: { grid: { drawOnChartArea: false } },
                            y: { beginAtZero: true }
                        },
                        elements: {
                            point: { radius: 3, hitRadius: 10, hoverRadius: 5, hoverBorderWidth: 3 }
                        }
                    }
                });
            }
        })();




        // ---------------- Percent Chart (Backend) ----------------
        const percentChartEl = document.getElementById("percent-chart");
        if (percentChartEl) {
            percentChartEl.height = 280;
            fetch('/api/chart/stok')
                .then(res => res.json())
                .then(response => {
                    const labels = response.labels;
                    const data = response.data;

                    new Chart(percentChartEl, {
                        type: 'doughnut',
                        data: {
                            labels: labels,
                            datasets: [{
                                label: "Stok Dağılımı (%)",
                                data: data,
                                backgroundColor: ['#00b5e9','#fa4251','#28a745','#ff6b35','#6f42c1'],
                                hoverBackgroundColor: ['#0099cc','#e63946','#20a745','#ff5722','#5e35b1'],
                                borderWidth: 2,
                                hoverBorderColor: '#fff'
                            }]
                        },
                        options: {
                            maintainAspectRatio: false,
                            responsive: true,
                            cutout: '75%',
                            plugins: {
                                legend: { display: true, position: 'bottom' },
                                tooltip: {
                                    callbacks: {
                                        label: function(context) {
                                            return `${context.label}: ${context.raw.toFixed(2)}%`;
                                        }
                                    }
                                }
                            },
                            animation: { animateScale: true, animateRotate: true }
                        }
                    });
                })
                .catch(err => console.error('Chart data fetch error:', err));
        }

    } catch (error) {
        console.log(error);
    }

})();

(async () => {
    const chartCtx = document.getElementById("recent-rep-tahmin-2025");
    const tbody = document.getElementById('tahminler-body');

    if (!chartCtx || !tbody) return;

    try {
        // Tek endpoint çağrısı: yorum eklemek için ?yorum=true
        const response = await fetch('/stok-tahminler?yorum=true');
        const tahminler = await response.json();

        // ---------------- Grafik için ----------------
        const data2025 = tahminler.filter(t => t.yil === 2025);
        const urunMap = {};
        data2025.forEach(t => {
            if (!urunMap[t.urun_id]) urunMap[t.urun_id] = [];
            urunMap[t.urun_id].push(t);
        });

        const colors = ['#fa4251', '#00b5e9', '#28a745', '#ffc107', '#6f42c1', '#17a2b8', '#ff5733', '#20c997'];
        const datasets = [];
        let labels = [];

        Object.keys(urunMap).forEach((urunId, index) => {
            const urunData = urunMap[urunId].sort((a, b) => a.ay - b.ay);
            const values = urunData.map(t => t.tahmin);

            if (index === 0) {
                const ayIsimleri = ['Ocak', 'Şubat', 'Mart', 'Nisan', 'Mayıs', 'Haziran',
                    'Temmuz', 'Ağustos', 'Eylül', 'Ekim', 'Kasım', 'Aralık'];
                labels = urunData.map(t => ayIsimleri[t.ay - 1]);
            }

            datasets.push({
                label: urunData[0].urun_adi,
                data: values,
                borderColor: colors[index % colors.length],
                backgroundColor: colors[index % colors.length] + '20',
                tension: 0.4,
                borderWidth: 3,
                pointRadius: 5,
                pointHoverRadius: 8,
                fill: false
            });
        });

        new Chart(chartCtx, {
            type: 'line',
            data: { labels, datasets },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                scales: {
                    y: {
                        beginAtZero: false,
                        grace: '5%',
                        ticks: { callback: v => v } // Yuvarlama yok
                    },
                    x: { grid: { display: false } }
                },
                plugins: {
                    legend: { display: true, position: 'top', labels: { usePointStyle: true, padding: 20 } },
                    tooltip: {
                        callbacks: {
                            label: ctx => ctx.dataset.label + ': ' + ctx.parsed.y.toFixed(2)
                        }
                    }
                },
                interaction: { intersect: false, mode: 'index' }
            }
        });

        // ---------------- Tablo için ----------------
        tbody.innerHTML = ''; // Önce temizle
        tahminler.forEach(t => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${t.urun_id}</td>
                <td>${t.urun_adi}</td>
                <td>${t.yil}</td>
                <td>${t.ay}</td>
                <td class="text-end">${t.tahmin}</td>
                <td class="text-end">${t.gecmis_ortalama}</td>
                <td class="text-end">${t.degisim_yuzde}</td>
                <td>${t.yorum}</td>
            `;
            tbody.appendChild(tr);
        });

    } catch (error) {
        console.error('Veri çekme hatası:', error);
        chartCtx.parentElement.innerHTML = '<div class="alert alert-danger">Grafik yüklenirken hata oluştu: ' + error.message + '</div>';
        tbody.innerHTML = '<tr><td colspan="8" class="text-center text-danger">Tablo yüklenirken hata oluştu</td></tr>';
    }
})();


// Animsition removed - using CSS transitions instead

// Recent Report Chart 2 for index2.html
(() => {
  "use strict";

  try {
    var ctx = document.getElementById("recent-rep2-chart");
    if (ctx) {
      ctx.height = 320;
      var myChart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
          datasets: [{
            label: 'Products',
            backgroundColor: 'rgba(0, 181, 233, 0.2)',
            borderColor: '#00b5e9',
            data: [65, 59, 84, 84, 51, 55, 40, 45, 50, 55, 70, 80],
            pointBackgroundColor: '#00b5e9',
            pointBorderColor: '#fff',
            pointBorderWidth: 2,
            pointRadius: 4,
            fill: true,
            tension: 0.4
          }, {
            label: 'Services',
            backgroundColor: 'rgba(76, 175, 80, 0.2)',
            borderColor: '#4caf50',
            data: [28, 48, 40, 19, 86, 27, 90, 70, 65, 85, 60, 75],
            pointBackgroundColor: '#4caf50',
            pointBorderColor: '#fff',
            pointBorderWidth: 2,
            pointRadius: 4,
            fill: true,
            tension: 0.4
          }]
        },
        options: {
          maintainAspectRatio: false,
          responsive: true,
          plugins: {
            legend: {
              display: false
            },
            tooltip: {
              backgroundColor: '#fff',
              titleColor: '#333',
              bodyColor: '#666',
              borderColor: '#ddd',
              borderWidth: 1,
              titleFont: {
                family: 'Poppins'
              },
              bodyFont: {
                family: 'Poppins'
              }
            }
          },
          scales: {
            x: {
              grid: {
                display: false
              },
              ticks: {
                font: {
                  family: "Poppins",
                  size: 12
                }
              }
            },
            y: {
              grid: {
                borderDash: [3, 3],
                color: '#e0e0e0',
                drawOnChartArea: true
              },
              ticks: {
                beginAtZero: true,
                maxTicksLimit: 6,
                font: {
                  family: "Poppins",
                  size: 12
                }
              }
            }
          },
          interaction: {
            intersect: false,
            mode: 'index'
          }
        }
      });
    }
  } catch (error) {
    console.log(error);
  }
})();

// WidgetChart 5 and Percent-Chart 2 for index3.html
(() => {
  "use strict";

  try {
    //WidgetChart 5 (for index3.html)
    var ctx = document.getElementById("widgetChart5");
    if (ctx) {
      ctx.height = 220;
      var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
          labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
          datasets: [{
            label: "Monthly Sales",
            data: [78, 81, 80, 64, 65, 80, 70, 75, 67, 85, 66, 68],
            borderColor: "transparent",
            borderWidth: "0",
            backgroundColor: "#3f51b5",
          }]
        },
        options: {
          maintainAspectRatio: true,
          plugins: {
            legend: {
              display: false
            }
          },
          scales: {
            x: {
              display: false,
              categoryPercentage: 1,
              barPercentage: 0.65
            },
            y: {
              display: false
            }
          }
        }
      });
    }

    //Percent Chart 2 (for index3.html)
    var ctx = document.getElementById("percent-chart2");
    if (ctx) {
      ctx.height = 209;
      var myChart = new Chart(ctx, {
        type: 'doughnut',
        data: {
          datasets: [{
            label: "Market Share",
            data: [65, 35],
            backgroundColor: [
              '#00b5e9',
              '#fa4251'
            ],
            hoverBackgroundColor: [
              '#0099cc',
              '#e63946'
            ],
            borderWidth: [2, 2],
            hoverBorderColor: [
              '#ffffff',
              '#ffffff'
            ]
          }],
          labels: [
            'Products',
            'Services'
          ]
        },
        options: {
          maintainAspectRatio: false,
          responsive: true,
          cutout: '80%',
          plugins: {
            legend: {
              display: true,
              position: 'bottom',
              labels: {
                usePointStyle: true,
                padding: 15,
                font: {
                  size: 12
                }
              }
            },
            tooltip: {
              backgroundColor: '#fff',
              titleColor: '#333',
              bodyColor: '#666',
              borderColor: '#ddd',
              borderWidth: 1,
              callbacks: {
                label: function(tooltipItem) {
                  var dataset = tooltipItem.dataset;
                  var value = dataset.data[tooltipItem.dataIndex];
                  var label = tooltipItem.chart.data.labels[tooltipItem.dataIndex];
                  return label + ': ' + value + '%';
                }
              }
            }
          },
          animation: {
            animateScale: true,
            animateRotate: true
          }
        }
      });
    }

    //Recent Report Chart 3 (for index4.html)
    var ctx = document.getElementById("recent-rep3-chart");
    if (ctx) {
      ctx.height = 230;
      var myChart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August'],
          datasets: [{
            label: 'Products',
            backgroundColor: 'rgba(33, 150, 243, 0.3)',
            borderColor: '#2196f3',
            pointHoverBackgroundColor: '#fff',
            borderWidth: 2,
            data: [78, 81, 80, 65, 58, 75, 60, 85],
            pointBackgroundColor: '#2196f3',
            fill: true,
            tension: 0.4
          }, {
            label: 'Services',
            backgroundColor: 'rgba(76, 175, 80, 0.3)',
            borderColor: '#4caf50',
            pointHoverBackgroundColor: '#fff',
            borderWidth: 2,
            data: [65, 59, 84, 84, 51, 55, 40, 70],
            pointBackgroundColor: '#4caf50',
            fill: true,
            tension: 0.4
          }]
        },
        options: {
          maintainAspectRatio: false,
          responsive: true,
          plugins: {
            legend: {
              display: true,
              position: 'top',
              labels: {
                usePointStyle: true,
                padding: 15,
                font: {
                  size: 12
                }
              }
            },
            tooltip: {
              backgroundColor: '#fff',
              titleColor: '#333',
              bodyColor: '#666',
              borderColor: '#ddd',
              borderWidth: 1,
              titleFont: {
                family: 'Poppins'
              },
              bodyFont: {
                family: 'Poppins'
              }
            }
          },
          scales: {
            x: {
              grid: {
                display: false
              },
              ticks: {
                font: {
                  family: "Poppins",
                  size: 12
                }
              }
            },
            y: {
              grid: {
                borderDash: [3, 3],
                color: '#e0e0e0'
              },
              ticks: {
                beginAtZero: true,
                maxTicksLimit: 6,
                font: {
                  family: "Poppins",
                  size: 12
                }
              }
            }
          }
        }
      });
    }

  } catch (error) {
    console.log(error);
  }
})();

// Vector Map placeholder - jQuery dependency removed
ready(() => {
  try {
    const vmapElement = $('#vmap');
    if (vmapElement) {
      // Replace with a simple colored div and message
      vmapElement.innerHTML = `
        <div style="
          width: 100%; 
          height: 284px; 
          background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
          display: flex;
          align-items: center;
          justify-content: center;
          color: white;
          font-size: 18px;
          border-radius: 4px;
        ">
          <div style="text-align: center;">
            <i class="fas fa-globe-americas" style="font-size: 48px; margin-bottom: 10px; display: block;"></i>
            Interactive World Map<br>
            <small style="font-size: 14px; opacity: 0.8;">Vector map functionality available</small>
          </div>
        </div>
      `;
    }
  } catch (error) {
    console.log(error);
  }
});

// Progress Bar - Vanilla JS Version
ready(() => {
  try {
    const progressbarSimple = $$('.js-progressbar-simple');

    progressbarSimple.forEach(element => {
      let executed = false;

      // Replace waypoint with Intersection Observer
      const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
          if (entry.isIntersecting && !executed) {
            executed = true;
            // Simple progress bar animation
            const progressBar = entry.target;
            const value = progressBar.getAttribute('data-transitiongoal') || progressBar.getAttribute('data-value') || 75;
            const valueElement = find(progressBar, '.js-value');

            let currentValue = 0;
            const increment = value / 50; // Slower animation
            const timer = setInterval(() => {
              currentValue += increment;
              if (currentValue >= value) {
                currentValue = value;
                clearInterval(timer);
              }
              if (valueElement) {
                valueElement.innerHTML = Math.round(currentValue) + '%';
              }
              // Set width directly for au-progress bars
              progressBar.style.width = currentValue + '%';
            }, 30);
          }
        });
      }, { threshold: 0.1 });

      observer.observe(element);
    });
  } catch (err) {
    console.log(err);
  }
});

// Perfect Scrollbar - Vanilla JS Version
ready(() => {
  try {
    const jscr1 = $('.js-scrollbar1');
    if (jscr1) {
      const ps1 = new PerfectScrollbar(jscr1);
    }

    const jscr2 = $('.js-scrollbar2');
    if (jscr2) {
      const ps2 = new PerfectScrollbar(jscr2);
    }

    const jscr3 = $('.js-scrollbar3');
    if (jscr3) {
      const ps3 = new PerfectScrollbar(jscr3);
    }

  } catch (error) {
    console.log(error);
  }

  // Enhanced table scrolling visibility
  const tableResponsive = $$('.table-responsive');
  tableResponsive.forEach(container => {
    // Check if table is wider than container
    const checkScroll = () => {
      const table = find(container, 'table');
      if (table && table.scrollWidth > container.clientWidth) {
        addClass(container, 'has-scroll');
      } else {
        removeClass(container, 'has-scroll');
      }
    };

    // Add scroll event listener to update shadow
    on(container, 'scroll', function() {
      if (this.scrollLeft > 0) {
        addClass(this, 'scrolled');
      } else {
        removeClass(this, 'scrolled');
      }
    });

    // Initial check
    checkScroll();

    // Recheck on window resize
    on(window, 'resize', checkScroll);
  });
});

// Select2 - Vanilla JS Version (would need replacement)
ready(() => {
  try {
    const select2Elements = $$(".js-select2");
    select2Elements.forEach(element => {
      // TODO: Replace with vanilla JS select library like Choices.js
      // For now, keep basic functionality
      console.log('Select2 element found, needs replacement with vanilla JS library');
    });
  } catch (error) {
    console.log(error);
  }
});

// Dropdown Menu - Vanilla JS Version
ready(() => {
  try {
    const menu = $$('.js-item-menu');
    let subMenuIsShowed = -1;

    menu.forEach((menuItem, index) => {
      on(menuItem, 'click', function(e) {
        e.preventDefault();
        const rightSidebar = $('.js-right-sidebar');
        if (rightSidebar) {
          removeClass(rightSidebar, 'show-sidebar');
        }

        if (index === subMenuIsShowed) {
          toggleClass(this, 'show-dropdown');
          subMenuIsShowed = -1;
        } else {
          menu.forEach(item => {
            removeClass(item, 'show-dropdown');
          });
          toggleClass(this, 'show-dropdown');
          subMenuIsShowed = index;
        }
      });
    });

    // Click outside to close
    on(document.body, 'click', function() {
      menu.forEach(item => {
        removeClass(item, 'show-dropdown');
      });
      subMenuIsShowed = -1;
    });

    // Prevent clicks inside dropdown from closing it
    $$(".js-item-menu, .js-dropdown").forEach(element => {
      on(element, 'click', function(event) {
        event.stopPropagation();
      });
    });

  } catch (error) {
    console.log(error);
  }

  // Right Sidebar
  try {
    const rightSidebar = $('.js-right-sidebar');
    const sidebarBtn = $('.js-sidebar-btn');

    if (sidebarBtn) {
      on(sidebarBtn, 'click', function(e) {
        e.preventDefault();
        const menu = $$('.js-item-menu');
        menu.forEach(item => {
          removeClass(item, 'show-dropdown');
        });
        if (rightSidebar) {
          toggleClass(rightSidebar, 'show-sidebar');
        }
      });
    }

    // Click outside to close sidebar
    on(document.body, 'click', function() {
      if (rightSidebar) {
        removeClass(rightSidebar, 'show-sidebar');
      }
    });

    // Prevent clicks inside sidebar from closing it
    $$(".js-right-sidebar, .js-sidebar-btn").forEach(element => {
      on(element, 'click', function(event) {
        event.stopPropagation();
      });
    });

  } catch (error) {
    console.log(error);
  }

  // Sublist Sidebar - Vanilla JS Version
  try {
    const arrows = $$('.js-arrow');
    arrows.forEach(arrow => {
      on(arrow, 'click', function(e) {
        e.preventDefault();
        const arrowIcon = find(this, '.arrow');
        const subList = find(this.parentNode, '.js-sub-list');

        if (arrowIcon) {
          toggleClass(arrowIcon, 'up');
        }
        toggleClass(this, 'open');

        if (subList) {
          slideToggle(subList, 250);
        }
      });
    });

  } catch (error) {
    console.log(error);
  }
});

// Hamburger Menu - Vanilla JS Version
ready(() => {
  try {
    const hamburger = $('.hamburger');
    const mobileMenu = $('.navbar-mobile');

    if (hamburger) {
      on(hamburger, 'click', function() {
        toggleClass(this, 'is-active');
        if (mobileMenu) {
          slideToggle(mobileMenu, 300);
        }
      });
    }

  } catch (error) {
    console.log(error);
  }
});

// Window resize handler
let resizeTimer;
on(window, 'resize', function() {
  clearTimeout(resizeTimer);
  resizeTimer = setTimeout(() => {
    // Handle responsive behavior
    const windowWidth = window.innerWidth;
    // Add responsive logic here
  }, 250);
});


console.log('CoolAdmin Vanilla JS initialized successfully');